package uk.co.mrdaly.adventofcode2023._02;

import java.util.List;
import java.util.stream.Collectors;

public class CubeConundrum {

    public int partOne(List<String> input, int maxRed, int maxGreen, int maxBlue) {
        return parseInput(input)
                .stream()
                .filter(game -> this.validateGame(game, maxRed, maxGreen, maxBlue))
                .mapToInt(Game::getNumber)
                .sum();
    }

    private List<Game> parseInput(List<String> input) {
        return input.stream().map(Game::new).collect(Collectors.toList());
    }

    private boolean validateGame(Game game, int maxRed, int maxGreen, int maxBlue) {
        return game.getMaxRed() <= maxRed
                && game.getMaxGreen() <= maxGreen
                && game.getMaxBlue() <= maxBlue;
    }

    public int partTwo(List<String> input) {
        return input.stream()
                .map(Game::new)
                .mapToInt(Game::getPower)
                .sum();
    }
}
