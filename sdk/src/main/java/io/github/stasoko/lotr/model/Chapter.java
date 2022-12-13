package io.github.stasoko.lotr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Plain Old Java Object (POJO) representing a chapter of a book.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chapter {
    @JsonProperty("_id")
    private String id = "";
    @JsonProperty("chapterName")
    private String name = "";

    @JsonProperty("book")
    private String bookId = "";
    private Book enclosingBook = new Book();

    /**
     * The default constructor
     *
     */
    public Chapter() {}

    /**
     * A constructor that sets fields, used for unit testing
     *
     * @param  id  the unique identifier of the chapter
     * @param  name  the name of the chapter
     * @param bookId  the unique identifier of the book
     */
    public Chapter(String id, String name, String bookId) {
        this.id = id;
        this.name = name;
        this.bookId = bookId;
    }

    /**
     * A getter method for the unique identifier
     *
     * @return  the unique identifier of the chapter
     */
    public String getId() {
        return id;
    }

    /**
     * A setter method for the unique identifier
     *
     * @param  id  the unique identifier of the chapter
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter method for the name of the chapter
     *
     * @return  the name of the chapter (the title)
     */
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    /**
     * A setter method for the name of the chapter
     *
     * @param  name  the name of the chapter (title)
     */
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter method for the unique identifier of the enclosing book
     *
     * @return  the unique identifier of the enclosing book
     */
    public String getBookId() { return bookId; }

    /**
     * A setter method for the unique identifier of the enclosing book
     *
     * @param bookId  the unique identifier of the enclosing book
     */
    public void setBookId(String bookId) { this.bookId = bookId; }

    /**
     * A getter method for the enclosing book
     *
     * @return  the enclosing book
     */
    @SuppressWarnings("unused")
    public Book getEnclosingBook() { return enclosingBook; }

    /**
     * A setter method for the enclosing book
     *
     * @param enclosingBook  the enclosing book
     */
    public void setEnclosingBook(Book enclosingBook) { this.enclosingBook = enclosingBook; }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bookId='" + bookId + '\'' +
                ", enclosingBookName='" + enclosingBook.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return id.equals(chapter.id) && name.equals(chapter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
