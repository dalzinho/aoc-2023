package uk.co.mrdaly.adventofcode2023._01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trebuchet {

    private static final Map<String, Integer> wordToInt = new HashMap<>();

    static {
        wordToInt.put("one", 1);
        wordToInt.put("two", 2);
        wordToInt.put("three", 3);
        wordToInt.put("four", 4);
        wordToInt.put("five", 5);
        wordToInt.put("six", 6);
        wordToInt.put("seven", 7);
        wordToInt.put("eight", 8);
        wordToInt.put("nine", 9);
    }

    public int partOne(List<String> input) {
        return input.stream()
                .mapToInt(this::sumFirstAndLastDigitInString)
                .sum();
    }

    private int sumFirstAndLastDigitInString(String input) {
        String[] ints = input
                .replaceAll("[a-z]", "")
                .split("");
        String first = ints[0];
        String last = ints[ints.length - 1];
        return Integer.parseInt(first + last);

    }

    public int partTwo(List<String> input) {
        return input.stream()
                .mapToInt(this::sumFirstAndLast)
                .sum();
    }

    private int sumFirstAndLast(String input) {
        int first = findFirstNumber(input);
        int last = findLastNumber(input);
        return Integer.parseInt("" + first + last);
    }

    private int findFirstNumber(String input) {

        if (input.matches("^\\d.*")) {
            return Integer.parseInt(input.substring(0, 1));
        }

        for (Map.Entry<String, Integer> entry : wordToInt.entrySet()) {
            if (input.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }


        return findFirstNumber(input.substring(1));
    }

    private int findLastNumber(String input) {

        if (input.matches(".*\\d$")) {
            String match = input.substring(input.length() - 1);
            return Integer.parseInt(match);
        }

        for (Map.Entry<String, Integer> entry : wordToInt.entrySet()) {
            if (input.endsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return findLastNumber(input.substring(0, input.length() - 1));

    }


}
