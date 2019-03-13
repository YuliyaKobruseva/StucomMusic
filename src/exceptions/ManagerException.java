/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Yuli
 */
public class ManagerException extends CodeException{
    
    // ManagerException codes
    public static final int USERS_EMPTY = 0;
    public static final int USER_EXIST = 1;
    public static final int INCORRECT_DATA = 2;
    public static final int SCORE_EXIST = 3;
    public static final int SCORES_EMPTY = 4;
    public static final int CURRENT_USER=5;
  
    // ManagerException messages
    private final List<String> messages = Arrays.asList(
            "There are not registered users",
            "User already exist",
            "User and/or password incorrect",
            "Score already exist",
            "There are not registred scores",
            "This user is used. Operation is not possible"
           );

    public ManagerException(int code) {
        super(code);
    }

    @Override
    public String getMessage() {
        return messages.get(getCode());
    }
}
