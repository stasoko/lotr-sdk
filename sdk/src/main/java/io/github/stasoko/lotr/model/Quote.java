package io.github.stasoko.lotr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Plain Old Java Object (POJO) representing a LOTR movie quote.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @JsonProperty("_id")
    private String id;
    private String dialog;
    private String movie;
    private String character;

    private String movieName;
    private String characterName;

    /**
     * The default constructor
     *
     */
    @SuppressWarnings("unused")
    public Quote() {}

    /**
     * A constructor that sets fields, used for unit testing
     *
     * @param  id  the unique identifier of the quote
     * @param  dialog  the text of the quote
     * @param  movie  the unique identifier (id) of the movie containing the quote
     * @param  character the character that spoke the quote
     */
    public Quote(String id, String dialog, String movie, String character) {
        this.id = id;
        this.dialog = dialog;
        this.movie = movie;
        this.character = character;
    }

    /**
     * A getter method for the unique identifier
     *
     * @return  the unique identifier of the quote
     */
    public String getId() {
        return id;
    }

    /**
     * A setter method for the unique identifier
     *
     * @param  id  the unique identifier of the quote
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter method for the text of the quote
     *
     * @return  the text of the quote
     */
    @SuppressWarnings("unused")
    public String getDialog() {
        return dialog;
    }

    /**
     * A setter method for the text of the quote
     *
     * @param dialog  the text of the quote
     */
    @SuppressWarnings("unused")
    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    /**
     * A getter method for the unique id of the movie containing the quote
     *
     * @return  the unique id of the movie containing the quote
     */
    public String getMovie() {
        return movie;
    }

    /**
     * A setter method for the unique id of the movie containing the quote
     *
     * @param movie   the unique id of the movie containing the quote
     */
    @SuppressWarnings("unused")
    public void setMovie(String movie) {
        this.movie = movie;
    }

    /**
     * A getter method for the unique id of the character who spoke the quote
     *
     * @return  the unique id of the character who spoke the quote
     */
    public String getCharacter() {
        return character;
    }

    /**
     * A setter method for the unique id of the character who spoke the quote
     *
     * @param character   the unique id of the character who spoke the quote
     */
    @SuppressWarnings("unused")
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * A getter method for the name of the movie containing the quote
     *
     * @return  the name of the movie containing the quote
     */
    @SuppressWarnings("unused")
    public String getMovieName() {
        return movieName;
    }

    /**
     * A setter method for the name of the movie containing the quote
     *
     * @param movieName   the name of the movie containing the quote
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * A getter method for the name of the character who spoke the quote
     *
     * @return  the name of the character who spoke the quote
     */
    @SuppressWarnings("unused")
    public String getCharacterName() { return characterName; }

    /**
     * A setter method for the name of the character who spoke the quote
     *
     * @param characterName   the name of the character who spoke the quote
     */
    public void setCharacterName(String characterName) { this.characterName = characterName; }

    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", dialog='" + dialog + '\'' +
                ", movie='" + movie + '\'' +
                ", character='" + character + '\'' +
                ", movieName='" + movieName + '\'' +
                ", characterName='" + characterName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id.equals(quote.id) && dialog.equals(quote.dialog) && movie.equals(quote.movie) && character.equals(quote.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dialog, movie, character);
    }
}
