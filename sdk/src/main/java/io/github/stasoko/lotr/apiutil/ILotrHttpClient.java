package io.github.stasoko.lotr.apiutil;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Interface for using the Java HTTP Client to perform an asynchronous get request.
 * Enables the use of mock objects.
*/
public interface ILotrHttpClient {
    /**
     * Uses the Java HTTP Client to perform an asynchronous get request.
     *
     * @param  endpoint  the end of the URL, appended to the end of the base URL
     * @param  mapper a function from the LotrMapper class, maps JSON to a POJO
     * @return      a completable future containing the mapped response, either a POJO or a list of POJOs
     */
    CompletableFuture<?> performGetRequest(String endpoint, Function<String, ?> mapper);
}
