/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Abstract class to work with Exception with code
 *
 * @author Yuli
 */
public abstract class CodeException extends Exception {

    // Code of exception
    private final int CODE;

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public int getCode() {
        return CODE;
    }

    /**
     * Set value of code
     *
     * @param code new value of code
     */
    public CodeException(int code) {
        this.CODE = code;
    }
}
