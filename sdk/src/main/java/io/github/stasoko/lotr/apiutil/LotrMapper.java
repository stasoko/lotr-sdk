package io.github.stasoko.lotr.apiutil;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.stasoko.lotr.model.Book;
import io.github.stasoko.lotr.model.Chapter;
import io.github.stasoko.lotr.model.Character;
import io.github.stasoko.lotr.model.Movie;
import io.github.stasoko.lotr.model.Quote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionException;

/**
 * Extends the Jackson ObjectMapper to map JSON to POJOs.
 */
public class LotrMapper extends com.fasterxml.jackson.databind.ObjectMapper {

    private final String ARRAY_NAME = "docs";

    /**
     * Maps JSON representing an array of book objects, called 'docs' into a List of Book POJOs
     *
     * @param  content  JSON content containing an array of book objects, called 'docs'
     * @return      a List of Book POJOs
     */
    public List<Book> mapBooks(String content) {
        try {
            JsonNode contentNode = readTree(content);
            List<Book> results = new ArrayList<>();
            if (contentNode.has(ARRAY_NAME)) {
                results = Arrays.asList(this.treeToValue(readTree(content).get(ARRAY_NAME), Book[].class));
            }
            return results;
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }

    /**
     * Maps JSON representing an array of chapter objects, called 'docs' into a List of Chapter POJOs
     *
     * @param  content  JSON content containing an array of chapter objects, called 'docs'
     * @return      a List of Chapter POJOs
     */
    public List<Chapter> mapChapters(String content) {
        try {
            JsonNode contentNode = readTree(content);
            List<Chapter> results = new ArrayList<>();
            if (contentNode.has(ARRAY_NAME)) {
                results = Arrays.asList(this.treeToValue(readTree(content).get(ARRAY_NAME), Chapter[].class));
            }
            return results;
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }

    /**
     * Maps JSON representing an array of movie objects, called 'docs' into a List of Movie POJOs
     *
     * @param  content  JSON content containing an array of movie objects, called 'docs'
     * @return      a List of Movie POJOs
     */
    public List<Movie> mapMovies(String content) {
        try {
            JsonNode contentNode = readTree(content);
            List<Movie> results = new ArrayList<>();
            if (contentNode.has(ARRAY_NAME)) {
                results = Arrays.asList(this.treeToValue(readTree(content).get(ARRAY_NAME), Movie[].class));
            }
            return results;
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }

    /**
     * Maps JSON representing an array of quote objects, called 'docs' into a List of Quote POJOs
     *
     * @param  content  JSON content containing an array of quote objects, called 'docs'
     * @return      a List of Quote POJOs
     */
    public List<Quote> mapQuotes(String content) {
        try {
            JsonNode contentNode = readTree(content);
            List<Quote> results = new ArrayList<>();
            if (contentNode.has(ARRAY_NAME)) {
                results = Arrays.asList(this.treeToValue(readTree(content).get(ARRAY_NAME), Quote[].class));
            }
            return results;
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }

    /**
     * Maps JSON representing an array of character objects, called 'docs' into a List of Character POJOs
     *
     * @param  content  JSON content containing an array of character objects, called 'docs'
     * @return      a List of Character POJOs
     */
    public List<Character> mapCharacters(String content) {
        try {
            JsonNode contentNode = readTree(content);
            List<Character> results = new ArrayList<>();
            if (contentNode.has(ARRAY_NAME)) {
                results = Arrays.asList(this.treeToValue(readTree(content).get(ARRAY_NAME), Character[].class));
            }
            return results;
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }
}
