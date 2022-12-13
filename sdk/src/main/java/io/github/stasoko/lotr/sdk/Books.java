package io.github.stasoko.lotr.sdk;

import io.github.stasoko.lotr.apiutil.ILotrHttpClient;
import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.model.Book;
import io.github.stasoko.lotr.model.Chapter;
import io.github.stasoko.lotr.model.SortDirection;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * SDK access to books.
 */
public class Books {
    private final ILotrHttpClient httpClient;
    private final LotrMapper mapper;
    private final String ENDPOINT = "book";
    private final Function<String, ?> mapperMethod;

    /**
     * A constructor that sets fields
     *
     * @param  httpClient  performs the get request
     * @param  mapper  maps the JSON response to POJOs
     */
    public Books(ILotrHttpClient httpClient, LotrMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        mapperMethod = mapper::mapBooks;
    }

    /**
     * A returns all books with an unspecified sort order
     *
     * @return    a list of books
     */
    public List<Book> getAll() {
        return getAllSorted("");
    }

    /**
     * A returns all books, sorted by name, in the specified order
     *
     * @param sortDirection the sort order
     * @return   a list of books
     */
    @SuppressWarnings("unused")
    public List<Book> getAllSortedByName(SortDirection sortDirection) {
        return getAllSorted(sortDirection.getUrlString("name"));
    }

    @SuppressWarnings("unchecked")
    private List<Book> getAllSorted(String sort) {
        CompletableFuture<List<Book>> booksFuture = (CompletableFuture<List<Book>>) httpClient.performGetRequest(ENDPOINT + sort, mapperMethod);
        return booksFuture.join();
    }


    /**
     * A returns a single book matching the specified id, an empty book is returned if no book is found
     *
     * @param id the unique identifier of the book
     * @return   the book that matches the id or an empty book
     */
    @SuppressWarnings("unchecked")
    public Book getById(String id) {
        CompletableFuture<List<Book>> booksFuture = (CompletableFuture<List<Book>>) httpClient.performGetRequest(ENDPOINT + "/" + id, mapperMethod);
        List<Book> books = booksFuture.join();
        return books.size() == 1 ? books.get(0) : new Book();
    }

    /**
     * A returns all chapters of the book that matches the id or an empty list if none are found
     *
     * @param id the unique identifier of the book
     * @return   all chapters of the book that matches the id or an empty list if none are found
     */
    @SuppressWarnings("unchecked")
    public List<Chapter> getChapters(String id) {
        CompletableFuture<List<Chapter>> chaptersFuture = (CompletableFuture<List<Chapter>>)
                httpClient.performGetRequest(ENDPOINT + "/" + id + "/chapter", mapper::mapChapters);

        Book book = getById(id);
        List<Chapter> chapters = chaptersFuture.join();
        chapters.forEach(chapter -> {
            chapter.setEnclosingBook(book);
            chapter.setBookId(id);
        });

        return chapters;
    }

    /**
     * A returns all chapters of the provided book
     *
     * @param book the book from which chapters will be retrieved
     * @return   all chapters of the book that matches the id or an empty list if none are found
     */
    @SuppressWarnings("unused")
    public List<Chapter> getChapters(Book book) {
        return getChapters(book.getId());
    }
}
