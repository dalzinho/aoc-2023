package uk.co.mrdaly.adventofcode2023._08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static uk.co.mrdaly.adventofcode2023.util.Maths.lcm;

public class HauntedWasteland {

    private static final String LEFT = "L";
    private static final String RIGHT = "R";

    public int partOne(List<String> input) {
        List<String> instructions = Arrays.asList(input.get(0).split(""));
        Map<String, Map<String, String>> map = buildMap(input.subList(2, input.size()));

        return solve("AAA", 0, instructions, map);
    }

    private int solve(String currentPosition, int stepCount, List<String> instructions, final Map<String, Map<String, String>> map) {
        for (String instruction : instructions) {
            stepCount++;
            currentPosition = map.get(currentPosition).get(instruction);
            if (currentPosition.equals("ZZZ")) {
                return stepCount;
            }
        }
        return solve(currentPosition, stepCount, instructions, map);
    }

    private Map<String, Map<String, String>> buildMap(List<String> input) {
        Pattern pattern = Pattern.compile("([\\w]{3}) = \\(([\\w]{3}), ([\\w]{3})\\)");
        Map<String, Map<String, String>> result = new HashMap<>();
        for (String line : input) {
            Matcher m = pattern.matcher(line);
            m.find();
            Map<String, String> innerMap = new HashMap<>();
            innerMap.put(LEFT, m.group(2));
            innerMap.put(RIGHT, m.group(3));
            result.put(m.group(1), innerMap);
        }
        return result;
    }


    public long partTwo(List<String> input) {
        List<String> instructions = Arrays.asList(input.get(0).split(""));
        Map<String, Map<String, String>> map = buildMap(input.subList(2, input.size()));
        List<Long> longs = map.keySet().stream()
                .filter(s -> s.endsWith("A"))
                .mapToLong(s -> solveForPartTwo(s, 0, instructions, map))
                .boxed()
                .toList();


        return lcm(longs);
    }

    private int solveForPartTwo(String currentPosition, int stepCount, List<String> instructions, final Map<String, Map<String, String>> map) {
        for (String instruction : instructions) {
            stepCount++;
            currentPosition = map.get(currentPosition).get(instruction);
            if (currentPosition.endsWith("Z")) {
                return stepCount;
            }
        }
        return solveForPartTwo(currentPosition, stepCount, instructions, map);
    }
}
