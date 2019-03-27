/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Exception of problems with file
 *
 * @author Yuli
 */
public class InputOutputException extends CodeException {

    // Exception codes
    public static final int FILE_ERROR = 0;
    public static final int CLOSE_OR_FLUSHING_FILE_ERROR=1;
    public static final int CLOSE_FILE_ERROR =2;
    public static final int DELETE_FILE_ERROR = 3;

    // Exception messages
    private final List<String> messages = Arrays.asList(
            "Error in CsvFileWriter",
            "Error while flushing/closing fileWriter",
            "Error while closing fileReader",
            "Error while deleting file"
    );

    public InputOutputException(int code) {
        super(code);
    }

    @Override
    public String getMessage() {
        return messages.get(getCode());
    }
}
