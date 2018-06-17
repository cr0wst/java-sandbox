package net.smcrow.sandbox.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllExceptCurrentInline {
    private static final List<String> FRIENDS = List.of("Sarah", "John", "Megan", "Joseph");

    public static void main(String... args) {
        System.out.println("Without Streams");
        withoutStreams();

        System.out.println("With Streams");
        withStreams();
    }

    private static void withoutStreams() {
        for (String person : FRIENDS) {
            List<String> friends = new ArrayList<>(FRIENDS);
            friends.remove(person);
            System.out.println("Friends of " + person + ": " + String.join(", ", friends));
        }
    }

    private static void withStreams() {
        FRIENDS.forEach(person -> {
            String friends = FRIENDS.stream().filter(other -> !person.equals(other)).collect(Collectors.joining(", "));
            System.out.println("Friends of " + person + ": " + friends);
        });
    }
}
