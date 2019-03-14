/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.ManagerException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.enums.TypeDifficultyLevel;
import model.enums.TypeGenre;
import model.enums.TypeInstrument;
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
     */
    public void initData() {

        if (InputOutputFile.readFromFile(users, "users")) {
            users.forEach((user) -> {
                InputOutputFile.readFromFile(users, user.getName());
            });
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
     */
    public boolean addNewScore(String code, String title, String artist, String instrument, String genre, String difficultyLevel, boolean isPrinted) throws ManagerException {
        if (checkExistScore(code) != null) {
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
     */
    public boolean modifyScore(String code, String title, String artist, String instrument, String genre, String difficultyLevel, boolean isPrinted) {
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
     */
    public boolean deleteScore(Score score) {
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
     */
    public boolean addNewUser(String name, String password, boolean isAdmin) {
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
     */
    public boolean deleteUser(User user) throws ManagerException {
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
     */
    public Score checkExistScore(String code) throws ManagerException {
        Score scoreExist = null;
        TreeMap<String, Score> userScores = Manager.getManager().getCurrentUser().getScores();
        if (!userScores.isEmpty()) {
            for (Map.Entry<String, Score> searchScore : userScores.entrySet()) {
                if (code.equalsIgnoreCase(searchScore.getKey())) {
                    scoreExist = searchScore.getValue();
                }
            }
        }
        return scoreExist;
    }

    /**
     *
     * @param userName
     * @return
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
     */
    public boolean checkPassword(String password1, String password2) {
        return password1.equals(password2);
    }

    /**
     *
     * @param buttonGroup
     * @return
     */
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    /**
     *
     * @param buttonSelected
     * @param buttonGroup
     */
    public void setSelectedButtonText(String buttonSelected, ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.getText().equalsIgnoreCase(buttonSelected)) {
                button.setSelected(true);
            }
        }
    }

    /**
     *
     * @param typeInstrument
     * @param level
     * @return
     */
    public ArrayList selectedScores(String typeInstrument, String level) throws ManagerException {
        ArrayList<Score> scores = allScores();
        ArrayList<Score> scoresSearch = null;
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
            }
        }
        scores = scoresSearch;
        return scores;
    }

//    public ArrayList positionsScores(TreeMap<String, Score> scores){
//        ArrayList<String> positions= new ArrayList<String>();
//        scores.entrySet().forEach((score) -> {
//            positions.add(score.getValue().getTitle());
//        });
//        return positions;
//    }
    /**
     *
     * @return
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
     * @param comboBox
     * @param typeComboBox
     */
    public void generateSelect(JComboBox<String> comboBox, String typeComboBox) {
        switch (typeComboBox) {
            case "genre":
                for (TypeGenre genre : TypeGenre.values()) {
                    comboBox.addItem(genre.toString());
                }
                break;
            case "instrument":
                for (TypeInstrument genre : TypeInstrument.values()) {
                    comboBox.addItem(genre.toString());
                }
                break;
            case "level":
                for (TypeDifficultyLevel level : TypeDifficultyLevel.values()) {
                    comboBox.addItem(level.toString());
                }
                break;
            case "user":
                users.forEach((user) -> {
                    comboBox.addItem(user.getName());
                });
            default:
                break;
        }
    }

    /**
     *
     * @param typeQuantity
     * @param typeQuantityName
     * @return
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
     *
     * @param dialog
     * @param frame
     */
    public void setIcon(JDialog dialog, JFrame frame) {
        if (dialog == null) {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconLogin.png")));
        } else {
            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconLogin.png")));
        }
    }

    /**
     *
     * @param newTable
     * @param typeTable
     */
    public void createTable(JTable newTable, String typeTable) throws ManagerException {
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> rows = new ArrayList<>();
        if (typeTable.equalsIgnoreCase("level")) {
            for (TypeDifficultyLevel level : TypeDifficultyLevel.values()) {
                columns.add(level.toString());
                rows.add(quantityScores(typeTable, level.toString()));
            }
        } else if (typeTable.equalsIgnoreCase("instrument")) {
            for (TypeInstrument instrument : TypeInstrument.values()) {
                columns.add(instrument.toString());
                rows.add(quantityScores(typeTable, instrument.toString()));
            }
        } else if (typeTable.equalsIgnoreCase("genre")) {
            for (TypeGenre genre : TypeGenre.values()) {
                columns.add(genre.toString());
                rows.add(quantityScores(typeTable, genre.toString()));
            }
        }
        DefaultTableModel model = new DefaultTableModel(null, columns.toArray());
        model.addRow(rows.toArray());
        newTable.setModel(model);
        newTable.setEnabled(false);
    }

    public User scoreOwner(String scoreCode) throws ManagerException {
        if (!users.isEmpty()) {
            for (User userApp : users) {
                TreeMap<String, Score> userScores = userApp.getScores();
                if (!userScores.isEmpty()) {
                    for (Map.Entry<String, Score> score : userScores.entrySet()) {
                        if (score.getValue().getCode().equalsIgnoreCase(scoreCode)) {
                            return userApp;
                        }
                    }
                }
            }
        } else {
            throw new ManagerException(ManagerException.USERS_EMPTY);
        }
        return null;
    }
}
