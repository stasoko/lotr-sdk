package io.github.stasoko.lotr.example;

import io.github.stasoko.lotr.model.*;
import io.github.stasoko.lotr.model.Character;
import io.github.stasoko.lotr.sdk.LotrSdk;

import java.util.List;
import java.util.Set;

public class LotrSdkExample {

    public static void main(String[] args) {

        // Retrieve an access token from https://the-one-api.dev
        final String ACCESS_TOKEN = "VVuoczLP6PjjkSMQxOjr";
        LotrSdk sdk = new LotrSdk(ACCESS_TOKEN);

        // Retrieve all books
        List<Book> books = sdk.getBooks().getAll();
        System.out.println("Books...");
        books.forEach(System.out::println);

        // Retrieve books sorted in ascending (alphabetical) order by name
        List<Book> booksSorted = sdk.getBooks().getAllSortedByName(SortDirection.ASC);
        System.out.println("Books sorted ascending...");
        booksSorted.forEach(System.out::println);

        // Retrieve a book by id
        Book book = sdk.getBooks().getById("5cf58077b53e011a64671583");
        System.out.println("Individual book...");
        System.out.println(book);

        // Get a character by name
        Character character = sdk.getCharacters().getByName("Eradan");
        System.out.println("Character Eradan...");
        System.out.println(character);

        // List all races
        Set<String> races = sdk.getCharacters().getRaces();
        races.forEach(System.out::println);

        // Get characters by race
        List<Character> characters = sdk.getCharacters().getCharactersByRace("Werewolves", "Orc", "Ent");
        characters.forEach(System.out::println);

    }
}
