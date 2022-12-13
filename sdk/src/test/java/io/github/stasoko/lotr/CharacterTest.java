package io.github.stasoko.lotr;

import io.github.stasoko.lotr.apiutil.LotrMapper;
import io.github.stasoko.lotr.mock.MockLotrHttpClient;
import io.github.stasoko.lotr.model.Character;
import io.github.stasoko.lotr.sdk.Characters;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    private final MockLotrHttpClient mockHttpClient = new MockLotrHttpClient();
    private final LotrMapper mapper = new LotrMapper();
    private final Characters characters = new Characters(mockHttpClient, mapper);

    @Test
    public void testGetAll() {
        List<Character> expected = new ArrayList<>();
        expected.add(new Character("1", "11 ft", "race 1", "gender 1", "birth 1", "spouse 1",
                "death 1", "realm 1", "hear 1", "name 1", "wiki 1"));
        expected.add(new Character("2", "21 ft", "race 2", "gender 2", "birth 2", "spouse 2",
                "death 2", "realm 2", "hear 2", "name 2", "wiki 2"));
        expected.add(new Character("3", "31 ft", "race 3", "gender 3", "birth 3", "spouse 3",
                "death 3", "realm 3", "hear 3", "name 3", "wiki 3"));

        mockHttpClient.setContentToMap(expected);
        List<Character> actual = characters.getAll();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetById() {
        List<Character> expected = new ArrayList<>();
        expected.add(new Character("1", "11 ft", "race 1", "gender 1", "birth 1", "spouse 1",
                "death 1", "realm 1", "hear 1", "name 1", "wiki 1"));

        mockHttpClient.setContentToMap(expected);
        Character actual = characters.getById("not used in test");
        assertEquals(expected.get(0), actual);
    }

    @Test
    public void testGetByIdNotFound() {
        mockHttpClient.setContentToMap("{" +
                "    \"success\": false," +
                "    \"message\": \"Something went wrong.\"" +
                "}");

        Character actual = characters.getById("not used in test");
        assertEquals("", actual.getId());
    }
}
