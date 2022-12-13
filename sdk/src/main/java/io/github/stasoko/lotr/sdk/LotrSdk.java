package io.github.stasoko.lotr.sdk;

import io.github.stasoko.lotr.apiutil.LotrHttpClient;
import io.github.stasoko.lotr.apiutil.LotrMapper;

/**
 * The main SDK class.  Used to access the https://the-one-api.dev API.
 */
@SuppressWarnings("unused")
public class LotrSdk {

    private final Books books;
    private final Movies movies;
    private final Characters characters;

    private final Chapters chapters;

    /**
     * The constructor, which takes an access token
     *
     * @param accessToken  the access token for the API, requested from https://the-one-api.dev API.
     */
    public LotrSdk(String accessToken) {
        LotrHttpClient httpClient = new LotrHttpClient();
        httpClient.setAccessToken(accessToken);
        LotrMapper mapper = new LotrMapper();
        books = new Books(httpClient, mapper);
        chapters = new Chapters(httpClient, mapper);
        characters = new Characters(httpClient, mapper);
        movies = new Movies(httpClient, mapper);
        movies.setCharacters(characters);
        characters.setMovies(movies);
        chapters.setBooks(books);
    }

    /**
     * Gets the Movies SDK Object
     *
     * @return the Movies SDK object
     */
    public Movies getMovies() {
        return movies;
    }

    /**
     * Gets the Books SDK Object
     *
     * @return the Books SDK object
     */
    public Books getBooks() {
        return books;
    }

    /**
     * Gets the Characters SDK Object
     *
     * @return the Characters SDK object
     */
    public Characters getCharacters() { return characters; }

    /**
     * Gets the Chapters SDK Object
     *
     * @return the Chapters SDK object
     */
    public Chapters getChapters() { return chapters; }

}
