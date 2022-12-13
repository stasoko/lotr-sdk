package io.github.stasoko.lotr.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.stasoko.lotr.apiutil.ILotrHttpClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class MockLotrHttpClient implements ILotrHttpClient {

    private String contentToMap = "";

    @Override
    public CompletableFuture<?> performGetRequest(String endpoint, Function<String, ?> mapper) {

        CompletableFuture<Object> result = new CompletableFuture<>();
        result.complete(mapper.apply(contentToMap));
        return result;
    }

    public void setContentToMap(String content) {
        this.contentToMap = content;
    }

    public void setContentToMap(List<?> content) {
        try {
            ObjectMapper jacksonMapper = new ObjectMapper();
            this.contentToMap = "{\"docs\":" + jacksonMapper.writeValueAsString(content) + "}";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
