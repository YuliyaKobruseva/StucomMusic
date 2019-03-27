/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.InputOutputException;
import exceptions.ManagerException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import model.score.Score;
import model.user.User;
import persistence.InputOutputFile;

/**
 *
 * @author Yuli
 */
public class Manager {

    private HashSet<User> users;
    private static Manager manager;
    private User currentUser;

    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public HashSet<User> getUsers() {
        return users;
    }

    /**
     * Get the value of currentUser
     *
     * @return the value of currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Set the value of currentUser
     *
     * @param currentUser new value of currentUser
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * Method that allows access to the Manager
     *
     * @return singleton
     */
    public static synchronized Manager getManager() {
//        synchronized (Manager.class) {
        if (manager == null) {
            manager = new Manager();
        }
//        }
        return manager;
    }

    /**
     * Initialize data
     */
    private Manager() {
        users = new HashSet<>();
    }

    /**
     * This method load data from file
     *
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public void initData() throws InputOutputException {
        if (InputOutputFile.readFromFile(users, "users")) {
            for (User user : users) {
                InputOutputFile.readFromFile(users, user.getName());
            }
        } else {
            users.add(new User("admin", "admin", true));
            InputOutputFile.writeFile(users, "users");
        }
    }

    /**
     * Method that verifies the user's password
     *
     * @param userLogin userName
     * @param password password
     * @return object User
     * @throws ManagerException if user does not exist
     */
    public User loginVerify(String userLogin, String password) throws ManagerException {
        User userExist = null;
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getName().equalsIgnoreCase(userLogin) && user.getPassword().equals(password)) {
                    userExist = user;
                    Manager.getManager().setCurrentUser(user);
                }
            }
        } else {
            throw new ManagerException(ManagerException.USERS_EMPTY);
        }
        return userExist;
    }

    /**
     * Method to create new score
     *
     * @param code code of score
     * @param title title of score
     * @param artist artist of score
     * @param genre genre of score
     * @param instrument type of instrument of score
     * @param difficultyLevel difficulty level of score
     * @param isPrinted is score is printed
     * @return true if score was created successul if it does not return false
     * @throws ManagerException if score already exist
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public boolean addNewScore(String code, String title, String artist, String instrument, String genre, String difficultyLevel, boolean isPrinted) throws ManagerException, InputOutputException {
        if (checkExistUserScore(code) != null) {
            throw new ManagerException(ManagerException.SCORE_EXIST);
        } else {
            Score newScore = new Score(code, title, artist, instrument, genre, difficultyLevel, isPrinted);
            currentUser.setScores(newScore);
            InputOutputFile.writeFile(users, currentUser.getName());
        }
        return true;
    }

    /**
     * Method to modify score
     *
     * @param code code of score
     * @param title title of score
     * @param artist artist of score
     * @param genre genre of score
     * @param instrument type of instrument of score
     * @param difficultyLevel difficulty level of score
     * @param isPrinted is score is printed
     * @return true if score was modified successul if it does not return false
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public boolean modifyScore(String code, String title, String artist, String instrument, String genre, String difficultyLevel, boolean isPrinted) throws InputOutputException {
        Score modifiedScore = new Score(code, title, artist, instrument, genre, difficultyLevel, isPrinted);
        if (currentUser.setScores(modifiedScore) != null) {
            InputOutputFile.writeFile(users, currentUser.getName());
            return true;
        }
        return false;
    }

    /**
     * Method to delete score
     *
     * @param score object Score for deete
     * @return true if score was deleted successul if it does not return false
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public boolean deleteScore(Score score) throws InputOutputException {
        if (currentUser.getScores().remove(score.getCode()) != null) {
            InputOutputFile.writeFile(users, currentUser.getName());
            return true;
        }
        return false;
    }

    /**
     * Method to create a new User
     *
     * @param name name of User
     * @param password password of User
     * @param isAdmin type of permission for user
     * @return true if user was created successul if it does not return false
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public boolean addNewUser(String name, String password, boolean isAdmin) throws InputOutputException {
        if (users.add(new User(name, password, isAdmin))) {
            InputOutputFile.writeFile(users, "users");
            return true;
        }
        return false;
    }

    /**
     * Method to delete user
     *
     * @param user object User
     * @return true if user was deleted successul if it does not return false
     * @throws exceptions.ManagerException
     * @throws exceptions.InputOutputException
     */
    public boolean deleteUser(User user) throws ManagerException, InputOutputException {
        if (user.equals(currentUser)) {
            throw new ManagerException(ManagerException.CURRENT_USER);
        } else {
            if (users.remove(user)) {
                InputOutputFile.writeFile(users, "users");
                InputOutputFile.deleteFile(user.getName());
                return true;
            }
            return false;
        }
    }

    /**
     * Method to check if the score of user is registered in system
     *
     * @param code code of score
     * @return if score exist return true, else return null
     * @throws exceptions.ManagerException if user don´t have registred scores
     */
    public Score checkExistUserScore(String code) throws ManagerException {
        Score scoreExist = null;
        if (!currentUser.getScores().isEmpty()) {
            if (currentUser.getScores().containsKey(code)) {
                scoreExist = (Score) currentUser.getScores().get(code);
            }
        } else {
            throw new ManagerException(ManagerException.SCORES_EMPTY);
        }
        return scoreExist;
    }

    /**
     * Method to check if user is registred in system
     *
     * @param userName name of user
     * @return if user is registred return object user, else return null
     * @throws exceptions.ManagerException if there is no registered user
     */
    public User checkExistUser(String userName) throws ManagerException {
        User user = null;
        if (users.isEmpty()) {
            throw new ManagerException(ManagerException.USERS_EMPTY);
        } else {
            for (User userSearch : users) {
                if (userSearch.getName().equalsIgnoreCase(userName)) {
                    user = userSearch;
                }
            }
        }
        return user;
    }

    /**
     * Method to check if the passwords are the same
     *
     * @param password1 password number one
     * @param password2 password number two
     * @return if they are the same
     */
    public boolean checkPassword(String password1, String password2) {
        return password1.equals(password2);
    }

    /**
     * Method that returns array with scores according to selected option
     *
     * @param typeInstrument type of instrument selected
     * @param level level selected
     * @return scores ArrayList
     * @throws exceptions.ManagerException if there are no scores with these
     * options
     */
    public ArrayList selectedScores(String typeInstrument, String level) throws ManagerException {
        ArrayList<Score> scores = allScores();
        ArrayList<Score> scoresSearch = new ArrayList<>();
        if (!scores.isEmpty()) {
            if ((!typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase(""))
                    || (typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase(""))
                    || (!typeInstrument.equalsIgnoreCase("") && level.equalsIgnoreCase(""))) {
                for (Score score : scores) {
                    if (!typeInstrument.equals("") && !level.equalsIgnoreCase("")) {
                        if (score.getInstrument().equalsIgnoreCase(typeInstrument) && score.getDifficultyLevel().equalsIgnoreCase(level)) {
                            System.out.println("2");
                            scoresSearch.add(score);
                        }
                    } else if (typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase("")) {
                        if (score.getDifficultyLevel().equalsIgnoreCase(level)) {
                            scoresSearch.add(score);
                        }
                    } else if (!typeInstrument.equalsIgnoreCase("") && level.equalsIgnoreCase("")) {
                        if (score.getInstrument().equalsIgnoreCase(typeInstrument)) {
                            scoresSearch.add(score);
                        }
                    }
                }
                scores = scoresSearch;
            }
        }
        return scores;
    }

    /**
     * Method that returns all scores recorded in application
     *
     * @return scores SrrayList
     * @throws exceptions.ManagerException if there are no registred user in
     * system
     */
    public ArrayList allScores() throws ManagerException {
        ArrayList<Score> allScores = new ArrayList();
        if (users.isEmpty()) {
            throw new ManagerException(ManagerException.USERS_EMPTY);
        } else {
            users.forEach((userApp) -> {
                TreeMap<String, Score> userScores = userApp.getScores();
                if (!userScores.isEmpty()) {
                    userScores.entrySet().forEach((score) -> {
                        allScores.add(score.getValue());
                    });
                }
            });
        }
        return allScores;
    }

    /**
     * Method that calculates the number of scores of the selected type
     *
     * @param typeQuantity type of quanity
     * @param typeQuantityName subtype
     * @return quantity of scores
     * @throws exceptions.ManagerException if there are no scores
     */
    public String quantityScores(String typeQuantity, String typeQuantityName) throws ManagerException {
        int quantity = 0;
        ArrayList<Score> scores = allScores();
        if (!scores.isEmpty()) {
            switch (typeQuantity) {
                case "genre":
                    for (Score score : scores) {
                        if (score.getGenre().equalsIgnoreCase(typeQuantityName)) {
                            quantity++;
                        }
                    }
                    break;
                case "instrument":
                    for (Score score : scores) {
                        if (score.getInstrument().equalsIgnoreCase(typeQuantityName)) {
                            quantity++;
                        }
                    }
                    break;
                case "level":
                    for (Score score : scores) {
                        if (score.getDifficultyLevel().equalsIgnoreCase(typeQuantityName)) {
                            quantity++;
                        }
                    }
                    break;
            }
        }
        return String.valueOf(quantity);
    }

    /**
     * Method to check score owner
     *
     * @param scoreCode code of score
     * @return object Iser
     * @throws ManagerException if there are no registred users in system
     */
    public User scoreOwner(String scoreCode) throws ManagerException {
        if (!users.isEmpty()) {
            for (User userApp : users) {
                TreeMap<String, Score> userScores = userApp.getScores();
                if (!userScores.isEmpty()) {
                    if (userScores.containsKey(scoreCode)) {
                        return userApp;
                    }
                }
            }
        } else {
            throw new ManagerException(ManagerException.USERS_EMPTY);
        }
        return null;
    }

    /**
     * Method to update user password
     *
     * @param password new password
     * @param user user
     * @throws exceptions.InputOutputException if there was any problem with
     * file
     */
    public void updateUserPassword(String password, User user) throws InputOutputException {
        if (user.equals(currentUser)) {
            currentUser.setPassword(password);
        } else {
            user.setPassword(password);
        }
        InputOutputFile.writeFile(users, "users");
    }

    /**
     * Restrict cloning of object
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
