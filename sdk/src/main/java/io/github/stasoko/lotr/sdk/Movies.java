package io.github.stasoko.lotr.sdk;

import io.github.stasoko.lotr.apiutil.ILotrHttpClient;
import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.model.Character;
import io.github.stasoko.lotr.model.Movie;
import io.github.stasoko.lotr.model.Quote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * SDK access to movies.
 */
public class Movies {
    private final ILotrHttpClient httpClient;
    private final LotrMapper mapper;
    private final String ENDPOINT = "movie";
    private final Function<String, ?> mapperMethod;
    private Characters characters;

    /**
     * A constructor that sets fields
     *
     * @param  httpClient  performs the get request
     * @param  mapper  maps the JSON response to POJOs
     */
    public Movies(ILotrHttpClient httpClient, LotrMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        mapperMethod = mapper::mapMovies;
    }

    /**
     * A setter for the characters SDK object, needed to retrieve additional data
     *
     * @param  characters  the characters SDK object
     */
    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    /**
     * Retrieves all movies
     *
     * @return  a list of all movies
     */
    @SuppressWarnings("unchecked")
    public List<Movie> getAll() {
        CompletableFuture<List<Movie>> movieFuture = (CompletableFuture<List<Movie>>) httpClient.performGetRequest(ENDPOINT, mapperMethod);
        return movieFuture.join();
    }

    /**
     * Retrieves a movie by id
     *
     * @param id the id of the movie to retrieve
     * @return  the movie, if found, or an empty movie
     */
    @SuppressWarnings("unchecked")
    public Movie getById(String id) {
        CompletableFuture<List<Movie>> movieFuture = (CompletableFuture<List<Movie>>) httpClient.performGetRequest(ENDPOINT + "/" + id, mapperMethod);
        List<Movie> movieList = movieFuture.join();

        return movieList.size() == 1 ? movieList.get(0) : new Movie();
    }

    /**
     * Retrieves quotes from the movie specified by the id
     *
     * @param id the id of the movie to retrieve quotes from
     * @return  a list of quotes, or an empty list if none are found
     */
    @SuppressWarnings("unchecked")
    public List<Quote> getQuotes(String id) {
        final String movieName = getById(id).getName();

        final Map<String, String> characterMap = new HashMap<>();
        if (characters != null) {
            List<Character> characterList = characters.getAll();
            characterMap.putAll(characterList.stream()
                    .collect(Collectors.toMap(Character::getId, Character::getName)));
        }
        CompletableFuture<List<Quote>> quotesFuture = (CompletableFuture<List<Quote>>) httpClient.performGetRequest(ENDPOINT + "/" + id + "/quote", mapper::mapQuotes);
        List<Quote> quotes = quotesFuture.join();
        quotes.forEach(quote -> {
            quote.setMovieName(movieName);
            String characterName = characterMap.getOrDefault(quote.getCharacter(), "");
            quote.setCharacterName(characterName);
        });
        return quotes;
    }
}
