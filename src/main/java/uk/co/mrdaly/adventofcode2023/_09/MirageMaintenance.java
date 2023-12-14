package uk.co.mrdaly.adventofcode2023._09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class MirageMaintenance {
    public int partOne(List<List<Integer>> input) {
        return solve(input, this::findNext);
    }

    private int solve(List<List<Integer>> input, ToIntFunction<List<List<Integer>>> function) {
        return input.stream()
                .map(List::of)
                .map(this::solveForOneRow)
                .mapToInt(function)
                .sum();
    }
    private List<List<Integer>> solveForOneRow(List<List<Integer>> result) {
        List<Integer> input = result.get(result.size() - 1);
        List<Integer> thisResult = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            thisResult.add(input.get(i) - input.get(i - 1));
        }

        if (thisResult.stream().allMatch(i -> i == 0)) {
            return result;
        } else {
            List<List<Integer>> nextResult = new ArrayList<>(result);
            nextResult.add(thisResult);
            return solveForOneRow(nextResult);
        }
    }

    private int findNext(List<List<Integer>> input) {
        return input.stream()
                .mapToInt(list -> list.get(list.size() -1))
                .sum();
    }

    public int partTwo(List<List<Integer>> input) {
        return solve(input, this::findPrevious);
    }

    private int findPrevious(List<List<Integer>> input) {
        List<Integer> firstEntries = input.stream().map(list -> list.get(0)).toList();

        int thing = 0;
        for (int i = firstEntries.size() - 1; i >= 0; i--) {
            thing = firstEntries.get(i) - thing;
        }
        return thing;
    }
}
