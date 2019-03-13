/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.util.TreeMap;
import model.score.Score;
import model.enums.TypeUser;

/**
 *
 * @author Yuli
 */
public class User {

    //comentar porque name es final
    private final String name;
    private String password;
    private TypeUser typeUser = TypeUser.USER;    
    private TreeMap<String, Score> scores;

    /**
     * Get the value of scores
     *
     * @return the value of scores
     */
    public TreeMap getScores() {
        return scores;
    }

    /**
     * Set the value of scores
     *
     * @param score new score
     */
    public Score setScores(Score score) {
       return this.scores.put(score.getCode(), score);
    }


    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        if (isAdmin) {
            this.typeUser = TypeUser.ADMIN;
        }else{
            this.typeUser = TypeUser.USER;
        }
        this.scores= new TreeMap();
    }

    /**
     * Get the value of typeUser
     *
     * @return the value of typeUser
     */
    public TypeUser getTypeUser() {
        return typeUser;
    }

    /**
     * Set the value of typeUser
     *
     * @param typeUser new value of typeUser
     */
    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

}
