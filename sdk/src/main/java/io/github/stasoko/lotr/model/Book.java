package io.github.stasoko.lotr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Plain Old Java Object (POJO) representing a book.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonProperty("_id")
    private String id = "";
    private String name = "";

    /**
     * The default constructor
     *
     */
    public Book() {}

    /**
     * A constructor that sets fields, used for unit testing
     *
     * @param  id  the unique identifier of the book
     * @param  name  the name of the book
     */
    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * A getter method for the unique identifier
     *
     * @return  the unique identifier of the book
     */
    public String getId() {
        return id;
    }

    /**
     * A setter method for the unique identifier
     *
     * @param  id  the unique identifier of the book
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter method for the name of the book
     *
     * @return  the name of the book (the title)
     */
    public String getName() {
        return name;
    }

    /**
     * A setter method for the name of the book
     *
     * @param  name  the name of the book (title)
     */
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) && name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
