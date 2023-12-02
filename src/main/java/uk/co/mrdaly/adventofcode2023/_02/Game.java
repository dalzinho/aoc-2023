package uk.co.mrdaly.adventofcode2023._02;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ToString
public class Game {

    @Getter
    private final int number;
    private final List<Integer> reds;
    private final List<Integer> greens;
    private final List<Integer> blues;

    public Game(String gameString) {
        this.reds = new ArrayList<>();
        this.greens = new ArrayList<>();
        this.blues = new ArrayList<>();

        String[] gameNoAndGames = gameString.split(":");
        String game = gameNoAndGames[0];
        this.number = Integer.parseInt(game.replace("Game ", ""));

        Stream.of(gameNoAndGames[1].split(";"))
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(String::trim)
                .forEach(this::processGame);


    }

    private void processGame(String game) {
        int count = Integer.parseInt(game.split(" ")[0]);
        String colour = game.split(" ")[1];
        if (colour.equals("red")) {
            reds.add(count);
        } else if (colour.equals("green")) {
            greens.add(count);
        } else if (colour.equals("blue")) {
            blues.add(count);
        }
    }

    private int getMax(List<Integer> ints) {
        return ints.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public int getMaxRed() {
        return getMax(this.reds);
    }


    public int getMaxGreen() {
        return getMax(this.greens);
    }

    public int getMaxBlue() {
        return getMax(this.blues);
    }

    private int getMin(List<Integer> ints) {
        return ints.stream().mapToInt(Integer::intValue).min().orElse(0);
    }
    public int getPower() {
        return getMaxRed() * getMaxGreen() * getMaxBlue();
    }
}
