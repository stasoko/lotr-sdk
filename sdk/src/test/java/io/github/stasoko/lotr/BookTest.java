package io.github.stasoko.lotr;

import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.mock.MockLotrHttpClient;
import io.github.stasoko.lotr.model.Book;
import io.github.stasoko.lotr.model.Chapter;
import io.github.stasoko.lotr.sdk.Books;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private final MockLotrHttpClient mockHttpClient = new MockLotrHttpClient();
    private final LotrMapper mapper = new LotrMapper();
    private final Books books = new Books(mockHttpClient, mapper);

    @Test
    public void testGetAll() {
            List<Book> expected = new ArrayList<>();
            expected.add(new Book("5cf5805fb53e011a64671582", "The Fellowship Of The Ring"));
            expected.add(new Book("5cf58077b53e011a64671583", "The Two Towers"));
            expected.add(new Book("5cf58080b53e011a64671584", "The Return Of The King"));

            mockHttpClient.setContentToMap(expected);
            List<Book> actual = books.getAll();
            assertEquals(expected, actual);
    }

    @Test
    public void testGetById() {
        List<Book> expected = new ArrayList<>();
        expected.add(new Book("5cf5805fb53e011a64671582", "The Fellowship Of The Ring"));

        mockHttpClient.setContentToMap(expected);
        Book actual = books.getById("not used in test");
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void testGetByIdNotFound() {
        mockHttpClient.setContentToMap("{" +
                "    \"success\": false," +
                "    \"message\": \"Something went wrong.\"" +
                "}");

        Book actual = books.getById("not used");
        assertEquals("", actual.getId());
    }

    @Test
    public void testGetChapters() {
        List<Chapter> expected = new ArrayList<>();
        expected.add(new Chapter("6091b6d6d58360f988133ba1", "The Departure of Boromir", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba2", "The Riders of Rohan", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba3", "The Uruk-Hai", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba", "Treebeard", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba5", "The White Rider", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba6", "The King of the Golden Hall", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba7", "Helm's Deep", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba8", "The Road to Isengard", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133ba9", "Flotsam and Jetsam", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133baa", "The Voice of Saruman", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133bab", "The Palantir", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133bac", "The Taming of Smeagol", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133bad", "The Passage of the Marshes", "Book 1"));
        expected.add(new Chapter("6091b6d6d58360f988133bae", "The Black Gate is Closed", "Book 1"));

        mockHttpClient.setContentToMap(expected);
        List<Chapter> actual = books.getChapters("id unused in test");
        assertEquals(expected, actual);
    }
}
