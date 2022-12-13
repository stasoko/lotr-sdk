package io.github.stasoko.lotr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Plain Old Java Object (POJO) representing a LOTR movie.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("_id")
    private String id = "";
    private String name = "";
    private int runtimeInMinutes = 0;
    private int budgetInMillions = 0;
    private int boxOfficeRevenueInMillions = 0;
    private int academyAwardNominations = 0;
    private int academyAwardWins = 0;
    private int rottenTomatoesScore = 0;

    /**
     * The default constructor
     *
     */
    public Movie() {}

    /**
     * A constructor that sets fields, used for unit testing
     *
     * @param  id  the unique identifier of the movie
     * @param  name  the name of the movie
     * @param  runtimeInMinutes  the duration of the movie, in minutes
     * @param  budgetInMillions the budget of the movie, in millions of dollars
     * @param  boxOfficeRevenueInMillions  how many millions of dollars the movie made at the box office
     * @param  academyAwardNominations how many times the movie was nominated for an Oscar
     * @param  academyAwardWins  how many times the movie won an Oscar
     * @param  rottenTomatoesScore  a rating of the movie's quality according to RottonTomatoes
     */
    public Movie(String id, String name,
                 int runtimeInMinutes,
                 int budgetInMillions,
                 int boxOfficeRevenueInMillions,
                 int academyAwardNominations,
                 int academyAwardWins,
                 int rottenTomatoesScore) {
        this.id = id;
        this.name = name;
        this.runtimeInMinutes = runtimeInMinutes;
        this.budgetInMillions = budgetInMillions;
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
        this.academyAwardNominations = academyAwardNominations;
        this.academyAwardWins = academyAwardWins;
        this.rottenTomatoesScore = rottenTomatoesScore;
    }

    /**
     * A getter method for the unique identifier
     *
     * @return  the unique identifier of the movie
     */
    public String getId() {
        return id;
    }

    /**
     * A setter method for the unique identifier
     *
     * @param  id  the unique identifier of the movie
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter method for the name of the movie
     *
     * @return  the name of the movie
     */
    public String getName() {
        return name;
    }

    /**
     * A setter method for the name of the movie
     *
     * @param name  the name of the movie
     */
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter method for the movie's duration
     *
     * @return  the duration of the movie, in minutes
     */
    @SuppressWarnings("unused")
    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    /**
     * A setter method for the movie's duration
     *
     * @param runtimeInMinutes   the duration of the movie, in minutes
     */
    @SuppressWarnings("unused")
    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    /**
     * A getter method for the movie's budget
     *
     * @return  the budget of the movie, in millions of dollars
     */
    @SuppressWarnings("unused")
    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    /**
     * A setter method for the movie's budget
     *
     * @param budgetInMillions   the budget of the movie, in millions of dollars
     */
    @SuppressWarnings("unused")
    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    /**
     * A getter method for how much money the movie made at the box office
     *
     * @return  how many millions of dollars the movie made at the box office
     */
    @SuppressWarnings("unused")
    public int getBoxOfficeRevenueInMillions() {
        return boxOfficeRevenueInMillions;
    }

    /**
     * A setter method for how much money the movie made at the box office
     *
     * @param boxOfficeRevenueInMillions   how many millions of dollars the movie made at the box office
     */
    @SuppressWarnings("unused")
    public void setBoxOfficeRevenueInMillions(int boxOfficeRevenueInMillions) {
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
    }

    /**
     * A getter method for how many times the movie was nominated for an Oscar
     *
     * @return  how many times the movie was nominated for an Oscar
     */
    @SuppressWarnings("unused")
    public int getAcademyAwardNominations() {
        return academyAwardNominations;
    }

    /**
     * A setter method for how many times the movie was nominated for an Oscar
     *
     * @param academyAwardNominations   how many times the movie was nominated for an Oscar
     */
    @SuppressWarnings("unused")
    public void setAcademyAwardNominations(int academyAwardNominations) {
        this.academyAwardNominations = academyAwardNominations;
    }

    /**
     * A getter method for how many times the movie won an Oscar
     *
     * @return  how many times the movie won an Oscar
     */
    @SuppressWarnings("unused")
    public int getAcademyAwardWins() {
        return academyAwardWins;
    }

    /**
     * A setter method for how many times the movie won an Oscar
     *
     * @param academyAwardWins   how many times the movie won an Oscar
     */
    @SuppressWarnings("unused")
    public void setAcademyAwardWins(int academyAwardWins) {
        this.academyAwardWins = academyAwardWins;
    }

    /**
     * A getter method for the movie's score on the RottonTomates site
     *
     * @return  a rating of the movie's quality according to RottonTomatoes
     */
    @SuppressWarnings("unused")
    public int getRottenTomatoesScore() {
        return rottenTomatoesScore;
    }

    /**
     * A setter method for the movie's score on the RottonTomates site
     *
     * @param rottenTomatoesScore   a rating of the movie's quality according to RottonTomatoes
     */
    @SuppressWarnings("unused")
    public void setRottenTomatoesScore(int rottenTomatoesScore) {
        this.rottenTomatoesScore = rottenTomatoesScore;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", runtimeInMinutes=" + runtimeInMinutes +
                ", budgetInMillions=" + budgetInMillions +
                ", boxOfficeRevenueInMillions=" + boxOfficeRevenueInMillions +
                ", academyAwardNominations=" + academyAwardNominations +
                ", academyAwardWins=" + academyAwardWins +
                ", rottenTomatoesScore=" + rottenTomatoesScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return runtimeInMinutes == movie.runtimeInMinutes && budgetInMillions == movie.budgetInMillions && boxOfficeRevenueInMillions == movie.boxOfficeRevenueInMillions && academyAwardNominations == movie.academyAwardNominations && academyAwardWins == movie.academyAwardWins && rottenTomatoesScore == movie.rottenTomatoesScore && id.equals(movie.id) && name.equals(movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, runtimeInMinutes, budgetInMillions, boxOfficeRevenueInMillions, academyAwardNominations, academyAwardWins, rottenTomatoesScore);
    }
}
