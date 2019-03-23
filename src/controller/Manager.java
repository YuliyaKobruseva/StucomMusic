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
     *
     * @return
     */
    public static Manager getManager() {
        if (manager == null) {
            manager = new Manager();
        }
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
     * @throws exceptions.InputOutputException
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
     *
     * @param userLogin
     * @param password
     * @return
     * @throws ManagerException
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
     *
     * @param code
     * @param title
     * @param artist
     * @param genre
     * @param instrument
     * @param difficultyLevel
     * @param isPrinted
     * @return
     * @throws ManagerException
     * @throws exceptions.InputOutputException
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
     *
     * @param code
     * @param title
     * @param artist
     * @param genre
     * @param instrument
     * @param difficultyLevel
     * @param isPrinted
     * @return
     * @throws exceptions.InputOutputException
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
     *
     * @param score
     * @return
     * @throws exceptions.InputOutputException
     */
    public boolean deleteScore(Score score) throws InputOutputException {
        if (currentUser.getScores().remove(score.getCode()) != null) {
            InputOutputFile.writeFile(users, currentUser.getName());
            return true;
        }
        return false;
    }

    /**
     *
     * @param name
     * @param password
     * @param isAdmin
     * @return
     * @throws exceptions.InputOutputException
     */
    public boolean addNewUser(String name, String password, boolean isAdmin) throws InputOutputException {
        if (users.add(new User(name, password, isAdmin))) {
            InputOutputFile.writeFile(users, "users");
            return true;
        }
        return false;
    }

    /**
     *
     * @param user
     * @return
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
     *
     * @param code
     * @return
     * @throws exceptions.ManagerException
     */
    public Score checkExistUserScore(String code) throws ManagerException {
        Score scoreExist = null;
        if (!currentUser.getScores().isEmpty()) {
            if (currentUser.getScores().containsKey(code)) {
                scoreExist = (Score) currentUser.getScores().get(code);
            }
        }
        return scoreExist;
    }

    /**
     *
     * @param userName
     * @return
     * @throws exceptions.ManagerException
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
     *
     * @param password1
     * @param password2
     * @return
     * @throws exceptions.ManagerException
     */
    public boolean checkPassword(String password1, String password2) throws ManagerException {
        return password1.equals(password2);
    }

    /**
     *
     * @param typeInstrument
     * @param level
     * @return
     * @throws exceptions.ManagerException
     */
    public ArrayList selectedScores(String typeInstrument, String level) throws ManagerException {
        ArrayList<Score> scores = allScores();
        ArrayList<Score> scoresSearch = new ArrayList<>();
        if (!scores.isEmpty()) {
            if ((!typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase(""))
                    || (typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase(""))
                    || (!typeInstrument.equalsIgnoreCase("") && level.equalsIgnoreCase(""))) {
                System.out.println("entra");
                for (Score score : scores) {
                    if (!typeInstrument.equals("") && !level.equalsIgnoreCase("")) {
                        if (score.getInstrument().equalsIgnoreCase(typeInstrument) && score.getDifficultyLevel().equalsIgnoreCase(level)) {
                            System.out.println("2");
                            scoresSearch.add(score);
                        }
                    } else if (typeInstrument.equalsIgnoreCase("") && !level.equalsIgnoreCase("")) {
                        System.out.println("inst");
                        if (score.getDifficultyLevel().equalsIgnoreCase(level)) {
                            scoresSearch.add(score);
                        }
                    } else if (!typeInstrument.equalsIgnoreCase("") && level.equalsIgnoreCase("")) {
                        System.out.println("level");
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
     *
     * @return @throws exceptions.ManagerException
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
     *
     * @param typeQuantity
     * @param typeQuantityName
     * @return
     * @throws exceptions.ManagerException
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
     * 
     * @param password
     * @param user 
     * @throws exceptions.InputOutputException 
     */
    public void updateUserPassword(String password, User user) throws InputOutputException {
        if (user.equals(currentUser)) {
            currentUser.setPassword(password);            
        } else {
            user.setPassword(password);
        }
        InputOutputFile.writeFile(users, "users");
    }
    
}
