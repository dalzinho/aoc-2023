package uk.co.mrdaly.adventofcode2023._04;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Card {

    @Getter
    private final int id;
    private final List<Integer> winners;
    private final List<Integer> heldNumbers;

    public Card(String input) {
        String[] elements = input.split(":");
        String idDetail = elements[0].replaceAll("Card ", "");
        this.id = Integer.parseInt(idDetail.trim());

        String[] numbers = elements[1].split("\\|");
        this.winners = parseNumberList(numbers[0]);
        this.heldNumbers = parseNumberList(numbers[1]);

    }

    private List<Integer> parseNumberList(String numberString) {
        return Arrays.stream(numberString.trim().split(" "))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getHeldWinners() {
        return heldNumbers.stream()
                .filter(winners::contains)
                .toList();
    }
}
