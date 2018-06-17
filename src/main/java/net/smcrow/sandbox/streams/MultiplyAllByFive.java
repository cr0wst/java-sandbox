package net.smcrow.sandbox.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyAllByFive {
    private static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5);

    public static void main(String... args) {
        System.out.println("Without Streams");
        withoutStreams();

        System.out.println("With Streams");
        withStreams();
    }

    private static void withoutStreams() {
        List<Integer> multiplied = new ArrayList<>();
        for (Integer number : NUMBERS) {
            multiplied.add(number * 5);
        }

        // To print the results you most likely used something like StringUtils.join, or Guava's Joiner
        // Or you did messy things like this (not recommended because of the replacement:
        String output = Arrays.toString(multiplied.toArray()).replace("[", "").replace("]", "");
        System.out.println(output);
    }

    private static void withStreams() {
        List<Integer> multiplied = NUMBERS.stream().map(i -> i * 5).collect(Collectors.toList());

        String output = multiplied.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
