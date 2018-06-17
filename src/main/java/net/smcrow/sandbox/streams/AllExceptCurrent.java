package net.smcrow.sandbox.streams;

import java.util.List;

public class AllExceptCurrent {
    private static final List<String> FRIENDS = List.of("Sarah", "John", "Megan", "Joseph");

    public static void main(String... args) {
        System.out.println("Without Streams");
        withoutStreams();

        System.out.println("With Streams");
        withStreams();
    }

    private static void withoutStreams() {
        for (String friend : FRIENDS) {
            System.out.println("Friends of " + friend + ":");
            for (String other : FRIENDS) {
                if (!friend.equals(other)) {
                    System.out.println(other);
                }
            }
        }
    }

    private static void withStreams() {
        FRIENDS.forEach(person -> {
            System.out.println("Friends of " + person + ":");
            FRIENDS.stream().filter(other -> !person.equals(other)).forEach(System.out::println);
        });
    }
}
