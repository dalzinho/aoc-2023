package uk.co.mrdaly.adventofcode2023._06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class WaitForIt {

    public long partOne(List<String> input) {
        List<Race> races = parseInput(input);

        return races.stream()
                .mapToInt(this::countWaysRaceCanBeWon)
                .reduce((a,b) -> a * b)
                .getAsInt();
    }

    public int countWaysRaceCanBeWon(Race race) {
        int result = 0;
        for (int i = 0; i < race.time(); i++) {
            int speed = i;
            long remainingTime = race.time() - i;
            long distanceCovered = speed * remainingTime;
            if (distanceCovered > race.distance()) {
                result++;
            }
        }
        return result;

    }



    public List<Race> parseInput(List<String> input) {
        List<Integer> times = numsToInts(input.get(0).split("Time:")[1]);
        List<Integer> distances = numsToInts(input.get(1).split("Distance:")[1]);
        return IntStream.range(0, times.size())
                .boxed()
                .map(i -> new Race(times.get(i), distances.get(i)))
                .toList();
    }

    private List<Integer> numsToInts(String nums) {
        return Arrays.stream(nums.split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }


    public long partTwo(long time, long distance) {
        Race race = new Race(time, distance);
        return countWaysRaceCanBeWon(race);
    }
}
