/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Exception of problems with commands
 * @author Yuli
 */
public class InputException extends CodeException{
    
     // Exception codes
//    public static final int WRONG_COMMAND = 0;
    

    // Exception messages
    private final List<String> messages = Arrays.asList(
//            "[ Wrong command ]"
    );

    public InputException(int code) {
        super(code);
    }

    @Override
    public String getMessage() {
        return messages.get(getCode());
    }
}
