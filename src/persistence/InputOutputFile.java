/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import model.score.Score;
import model.user.User;

/**
 * Class to load and save data in files
 *
 * @author Yuli
 */
public class InputOutputFile {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER_USER = "name, password, typeUser";
    private static final String FILE_HEADER_SCORE = "code, title, artist, instrument, genre, difficultyLevel, isPrinted";
    //System type separator adn folder for files
    private static final String SEPARATOR = File.separator;
    private static final String FOLDER_DATA = "data";

    //User attributes index
    private static final int USER_NAME = 0;
    private static final int USER_PASSWORD = 1;
    private static final int USER_TYPE = 2;
    //Score attribute index
    private static final int SCORE_CODE = 0;
    private static final int SCORE_TITLE = 1;
    private static final int SCORE_ARTIST = 2;
    private static final int SCORE_INSTRUMENT = 3;
    private static final int SCORE_GENRE = 4;
    private static final int SCORE_LEVEL = 5;
    private static final int SCORE_ISPRINTED = 6;

    /**
     * Create folder data if doesn't exist
     */
    public static void createFolderData() {
        File folder = new File(FOLDER_DATA);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    /**
     *
     * @param users
     * @param nameFile
     */
    public static void writeFile(HashSet<User> users, String nameFile) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FOLDER_DATA + SEPARATOR + nameFile);

            if (nameFile.equalsIgnoreCase("users")) {
                //Write the CSV file header           
                fileWriter.append(FILE_HEADER_USER);
                //Add a new line separator after the header
                fileWriter.append(NEW_LINE_SEPARATOR);
                //Write a new object list to the CSV file
                for (User user : users) {
                    fileWriter.append(user.getName());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(user.getPassword());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(user.getTypeUser()));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            } else {
                fileWriter.append(FILE_HEADER_SCORE);
                fileWriter.append(NEW_LINE_SEPARATOR);
                TreeMap<String, Score> userScores = new TreeMap();
                for (User user : users) {
                    if (user.getName().equalsIgnoreCase(nameFile)) {
                        userScores = user.getScores();
                    }
                }
                for (Map.Entry<String, Score> score : userScores.entrySet()) {
                    fileWriter.append(score.getValue().getCode());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(score.getValue().getTitle());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(score.getValue().getArtist());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(score.getValue().getInstrument());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(score.getValue().getGenre());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(score.getValue().getDifficultyLevel());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(score.getValue().isIsPrinted()));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (IOException ex) {
            System.out.println("Error in CsvFileWriter !!!");
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param users
     * @param fileName
     */
    public static void readFromFile(HashSet<User> users, String fileName) {
        BufferedReader fileReader = null;
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(FOLDER_DATA + SEPARATOR + fileName));
            //Read the CSV file header to skip it
            fileReader.readLine();
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    boolean isAdmin = tokens[USER_TYPE].equalsIgnoreCase("ADMIN");
                    User user = new User(tokens[USER_NAME], tokens[USER_PASSWORD], isAdmin);
                    users.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

    }

    /**
     * Delete user file with scores from app when deleting user
     *
     * @param nameFile user file name
     */
    public static void deleteFile(String nameFile) {
        try {
            File file = new File(FOLDER_DATA + SEPARATOR + nameFile);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
