package io.github.stasoko.lotr.apiutil;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * Uses the Java HTTP Client to perform an asynchronous get request.
 */
public class LotrHttpClient implements ILotrHttpClient {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private  String accessToken = "";
    private  String baseUrl = "https://the-one-api.dev/v2/";

    /**
     * Sets the API access token for https://the-one-api.dev.
     *
     * @param  accessToken  the access token obtained from https://the-one-api.dev
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Sets the base URL for the API.  This method is optional.  The default value is
     * https://the-one-api.dev/v2/.  The endpoint is concatenated to the end of the base URL
     * in the performGetRequest method.
     *
     * @param  baseUrl  the base URL of the API
     */
    @SuppressWarnings("unused")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Uses the Java HTTP Client to perform an asynchronous get request.
     *
     * @param  endpoint  the end of the URL, appended to the end of the base URL
     * @param  mapper a function from the LotrMapper class, maps JSON to a POJO
     * @return      a completable future containing the mapped response, either a POJO or a list of POJOs
     */
    public CompletableFuture<?> performGetRequest(String endpoint, Function<String, ?> mapper) {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .setHeader("Authorization", "Bearer " + accessToken)
                .build();

        return httpClient.sendAsync(getRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(mapper);
    }


}
