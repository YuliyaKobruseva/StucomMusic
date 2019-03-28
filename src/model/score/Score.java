/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.score;

/**
 *
 * @author Yuli
 */
public class Score {

    private final String code;
    private String title;
    private String artist;
    private String instrument;
    private String genre;
    private String difficultyLevel;
    private boolean isPrinted;

    /**
     * Constructor
     *
     * @param code
     * @param title
     * @param artist
     * @param instrument
     * @param genre
     * @param difficultyLevel
     * @param isPrinted
     */
    public Score(String code, String title, String artist, String instrument, String genre, String difficultyLevel, boolean isPrinted) {
        this.code = code;
        this.title = title;
        this.artist = artist;
        this.instrument = instrument;
        this.genre = genre;
        this.difficultyLevel = difficultyLevel;
        this.isPrinted = isPrinted;
    }

    /**
     * Get the value of isPrinted
     *
     * @return the value of isPrinted
     */
    public boolean isIsPrinted() {
        return isPrinted;
    }

    /**
     * Set the value of isPrinted
     *
     * @param isPrinted new value of isPrinted
     */
    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    /**
     * Get the value of difficultyLevel
     *
     * @return the value of difficultyLevel
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Set the value of difficultyLevel
     *
     * @param difficultyLevel new value of difficultyLevel
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Set the value of gender
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Get the value of instrument
     *
     * @return the value of instrument
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Set the value of instrument
     *
     * @param instrument new value of instrument
     */
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Get the value of artist
     *
     * @return the value of artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Set the value of artist
     *
     * @param artist new value of artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }
}
