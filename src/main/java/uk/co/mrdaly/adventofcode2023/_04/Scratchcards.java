package uk.co.mrdaly.adventofcode2023._04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratchcards {
    public int partOne(List<String> input) {
        return input.stream()
                .map(Card::new)
                .map(Card::getHeldWinners)
                .map(List::size)
                .filter(winningNumberCount -> winningNumberCount > 0)
                .mapToInt(this::countPointsFromCard)
                .sum();
    }

    private int countPointsFromCard(int winningNumbers) {
        int score = 1;

        for (int i = 1; i < winningNumbers; i++) {
            score *= 2;
        }
        return score;
    }

    public int partTwo(List<String> input) {
        Map<Integer, Integer> held = new HashMap<>();
        Map<Integer, Integer> cards = new HashMap<>();
        for (String s : input) {
            Card card = new Card(s);
            cards.put(card.getId(), card.getHeldWinners().size());
            held.put(card.getId(), 1);
        }

        return recurse(held, cards, 1);
    }

    private int recurse(Map<Integer, Integer> heldCards, Map<Integer, Integer> resultMap, int cardId) {
        if (cardId > resultMap.keySet().size()) {
            return heldCards.values().stream().mapToInt(Integer::intValue).sum();
        }

        int winnerCount = resultMap.get(cardId);

        if (winnerCount > 0) {
            int heldInstances = heldCards.get(cardId);
            for (int i = 1; i <= winnerCount; i++) {
                int cardToIncrement = cardId + i;
                int newAmount = heldCards.get(cardToIncrement) + heldInstances;
                heldCards.put(cardToIncrement, newAmount);
            }
        }
        return recurse(heldCards, resultMap, cardId + 1);
    }
}
