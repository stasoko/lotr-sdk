package io.github.stasoko.lotr;

import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.mock.MockLotrHttpClient;
import io.github.stasoko.lotr.model.Movie;
import io.github.stasoko.lotr.model.Quote;
import io.github.stasoko.lotr.sdk.Movies;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    private final MockLotrHttpClient mockHttpClient = new MockLotrHttpClient();
    private final LotrMapper mapper = new LotrMapper();
    private final Movies movies = new Movies(mockHttpClient, mapper);

    @Test
    public void testGetAll() {
        List<Movie> expected = new ArrayList<>();
        expected.add(new Movie("1", "Movie 1", 10, 20, 30, 40, 50, 60));
        expected.add(new Movie("2", "Movie 2", 11, 21, 31, 41, 51, 61));
        expected.add(new Movie("3", "Movie 3", 12, 22, 32, 42, 52, 62));
        expected.add(new Movie("4", "Movie 4", 13, 23, 33, 44, 53, 63));
        expected.add(new Movie("5", "Movie 5", 14, 24, 34, 45, 54, 64));

        mockHttpClient.setContentToMap(expected);
        List<Movie> actual = movies.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetById() {
        List<Movie> expected = new ArrayList<>();
        expected.add(new Movie("1", "Movie 1", 10, 20, 30, 40, 50, 60));

        mockHttpClient.setContentToMap(expected);
        Movie actual = movies.getById("1");
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void testGetByIdNotFound() {
        mockHttpClient.setContentToMap("{" +
                "    \"success\": false," +
                "    \"message\": \"Something went wrong.\"" +
                "}");

        Movie actual = movies.getById("not used");
        assertEquals("", actual.getId());
    }

    @Test
    public void testGetQuotes() {
        List<Quote> expected = new ArrayList<>();
        expected.add(new Quote("1", "dialog 1", "movie 1", "character 1"));
        expected.add(new Quote("2", "dialog 2", "movie 2", "character 2"));
        expected.add(new Quote("3", "dialog 3", "movie 3", "character 3"));
        expected.add(new Quote("4", "dialog 4", "movie 4", "character 4"));
        expected.add(new Quote("5", "dialog 5", "movie 5", "character 5"));

        mockHttpClient.setContentToMap(expected);

        List<Quote> actual = movies.getQuotes("not used in test");
        assertEquals(expected, actual);
    }
}
