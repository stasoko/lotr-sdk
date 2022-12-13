package io.github.stasoko.lotr.sdk;

import io.github.stasoko.lotr.apiutil.ILotrHttpClient;
import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.model.Character;
import io.github.stasoko.lotr.model.Movie;
import io.github.stasoko.lotr.model.Quote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * SDK access to characters.
 */
public class Characters {
    private final ILotrHttpClient httpClient;
    private final LotrMapper mapper;
    private final String ENDPOINT = "character";
    private final Function<String, ?> mapperMethod;
    private Movies movies;

    /**
     * A constructor that sets fields
     *
     * @param  httpClient  performs the get request
     * @param  mapper  maps the JSON response to POJOs
     */
    public Characters(ILotrHttpClient httpClient, LotrMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        mapperMethod = mapper::mapCharacters;
    }

    /**
     * A setter for the movies SDK object, needed to retrieve additional data
     *
     * @param  movies  the movies SDK object
     */
    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    /**
     * A gets all characters in all movies
     *
     * @return  a list of characters
     */
    @SuppressWarnings("unchecked")
    public List<Character> getAll() {
        CompletableFuture<List<Character>> characterFuture = (CompletableFuture<List<Character>>) httpClient.performGetRequest(ENDPOINT, mapperMethod);
        return characterFuture.join();
    }

    /**
     * A gets a character by character id
     *
     * @param id  the id of the character to retrieve
     * @return  the character, if found, or an empty character otherwise
     */
    @SuppressWarnings("unchecked")
    public Character getById(String id) {
        CompletableFuture<List<Character>> characterFuture = (CompletableFuture<List<Character>>) httpClient.performGetRequest(ENDPOINT + "/" + id, mapperMethod);
        List<Character> characterList = characterFuture.join();

        return characterList.size() == 1 ? characterList.get(0) : new Character();
    }

    /**
     * A gets a character by character name
     *
     * @param name  the name of the character to retrieve
     * @return  the character, if found, or an empty character otherwise
     */
    @SuppressWarnings({"unused", "unchecked"})
    public Character getByName(String name) {
        CompletableFuture<List<Character>> characterFuture = (CompletableFuture<List<Character>>) httpClient.performGetRequest(ENDPOINT + "?name=" + name, mapperMethod);
        List<Character> characterList = characterFuture.join();

        return characterList.size() == 1 ? characterList.get(0) : new Character();
    }

    /**
     * Lists all races
     *
     * @return  a set containing the name of each character race
     */
    @SuppressWarnings("unused")
    public Set<String> getRaces() {
        return getAll().stream().map(Character::getRace).collect(Collectors.toSet());
    }

    /**
     * Gets all characters of the specified races
     *
     * @param races varargs of the races to retrieve
     * @return  a list of characters that correspond to the specified races
     */
    @SuppressWarnings({"unused", "unchecked"})
    public List<Character> getCharactersByRace(String...races) {
        CompletableFuture<List<Character>> characterFuture = (CompletableFuture<List<Character>>)
                httpClient.performGetRequest(ENDPOINT + "?race=" + String.join(",", races),
                        mapperMethod);
        return characterFuture.join();
    }

    /**
     * Gets all quotes by the character specified in the id
     *
     * @param id the id of the character
     * @return quotes spoken by the character specified by the id
     */
    @SuppressWarnings({"unused", "unchecked"})
    public List<Quote> getQuotes(String id) {

        final Map<String, String> movieMap = new HashMap<>();
        if (movies != null) {
            List<Movie> movieList = movies.getAll();
            movieMap.putAll(movieList.stream().collect(Collectors.toMap(Movie::getId, Movie::getName)));
        }

        final String characterName = getById(id).getName();

        CompletableFuture<List<Quote>> quotesFuture = (CompletableFuture<List<Quote>>) httpClient.performGetRequest(ENDPOINT + "/" + id + "/quote", mapper::mapQuotes);
        List<Quote> quotes = quotesFuture.join();
        quotes.forEach(quote -> {
            quote.setMovieName(movieMap.getOrDefault(quote.getMovie(), ""));
            quote.setCharacterName(characterName);
        });
        return quotes;
    }
}
