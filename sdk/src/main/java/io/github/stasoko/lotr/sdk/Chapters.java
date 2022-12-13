package io.github.stasoko.lotr.sdk;

import io.github.stasoko.lotr.apiutil.ILotrHttpClient;
import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.model.Book;
import io.github.stasoko.lotr.model.Chapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * SDK access to chapters.
 */
public class Chapters {
    private final ILotrHttpClient httpClient;

    private final String ENDPOINT = "chapter";
    private final Function<String, ?> mapperMethod;

    private Books books;

    /**
     * A constructor that sets fields
     *
     * @param  httpClient  performs the get request
     * @param  mapper  maps the JSON response to POJOs
     */
    public Chapters(ILotrHttpClient httpClient, LotrMapper mapper) {
        this.httpClient = httpClient;
        mapperMethod = mapper::mapChapters;
    }

    /**
     * A setter for the books SDK object, needed to retrieve additional data
     *
     * @param  books  the books SDK object
     */
    public  void setBooks(Books books) {
        this.books = books;
    }

    /**
     * Retrieves all chapters in all books
     *
     * @return  a list of chapters
     */
    @SuppressWarnings({"unused", "unchecked"})
    public List<Chapter> getAll() {
        CompletableFuture<List<Chapter>> chapterFuture = (CompletableFuture<List<Chapter>>) httpClient.performGetRequest(ENDPOINT, mapperMethod);
        List<Chapter> chapters = chapterFuture.join();

        Map<String, Book> bookMap = new HashMap<>();
        if (books != null) {
            List<Book> bookList = books.getAll();
            bookMap.putAll(bookList.stream().collect(Collectors.toMap(Book::getId, Function.identity())));
        }

        chapters.forEach(chapter -> chapter.setEnclosingBook(bookMap.getOrDefault(chapter.getBookId(), new Book())));

        return chapterFuture.join();
    }

    /**
     * Retrieves a chapter by id
     *
     * @return  the chapter that matches the id, if found, otherwise an empty chapter
     */
    @SuppressWarnings({"unused", "unchecked"})
    public Chapter getById(String id) {
        CompletableFuture<List<Chapter>> chapterFuture = (CompletableFuture<List<Chapter>>) httpClient.performGetRequest(ENDPOINT + "/" + id, mapperMethod);
        List<Chapter> chapterList = chapterFuture.join();

        Chapter chapter = new Chapter();
        if (chapterList.size() == 1) {
            chapter = chapterList.get(0);
            chapter.setEnclosingBook(books.getById(chapter.getBookId()));
        }

        return chapter;
    }
}
