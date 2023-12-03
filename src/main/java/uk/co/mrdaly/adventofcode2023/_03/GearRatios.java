package uk.co.mrdaly.adventofcode2023._03;

import uk.co.mrdaly.adventofcode2023.util.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GearRatios {

    public int partOne(List<List<String>> input) {

        return parseInput(input).stream()
                .mapToInt(FoundNumber::getNumber)
                .sum();
    }

    private List<FoundNumber> parseInput(List<List<String>> input) {
        int maxRow = input.size() - 1;
        int maxColumn = input.get(0).size() - 1;
        StringBuilder sb = new StringBuilder();
        List<FoundNumber> numbers = new ArrayList<>();
        FoundNumber foundNumber = null;
        for (int row = 0; row <= maxRow; row++) {
            if (!sb.isEmpty() && foundNumber != null) {
                int number = Integer.parseInt(sb.toString());
                foundNumber.setNumber(number);
                numbers.add(foundNumber);
                sb = new StringBuilder();
                foundNumber = null;
            }
            for (int column = 0; column <= maxColumn; column++) {
                String test = input.get(row).get(column);
                if (!Character.isDigit(test.charAt(0))) {
                    if (!sb.isEmpty() && foundNumber != null) {
                        int number = Integer.parseInt(sb.toString());
                        foundNumber.setNumber(number);

                        numbers.add(foundNumber);
                        sb = new StringBuilder();
                        foundNumber = null;
                    } else {
                        sb = new StringBuilder();
                    }
                    continue;
                }
                sb.append(test);
                if (foundNumber == null) {
                    for (int rowStep = -1; rowStep <= 1; rowStep++) {
                        int testRow = row + rowStep;
                        if (testRow < 0 || testRow > maxRow) {
                            continue;
                        }

                        for (int columnStep = -1; columnStep <= 1; columnStep++) {
                            int testColumn = column + columnStep;
                            if (testColumn < 0 || testColumn > maxColumn) {
                                continue;
                            }
                            String stepTest = input.get(testRow).get(testColumn);
                            char stepTestChar = stepTest.charAt(0);
                            if (!stepTest.equals(".") && !Character.isDigit(stepTestChar)) {
                                foundNumber = new FoundNumber(stepTest, new Position(testColumn, testRow));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public int partTwo(List<List<String>> input) {
        List<FoundNumber> foundNumbersWithTimesSign = parseInput(input).stream()
                .filter(fn -> fn.getSymbol().equals("*"))
                .toList();

        return findGearRatios(foundNumbersWithTimesSign, new ArrayList<>())
                .stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> findGearRatios(List<FoundNumber> foundNumbers, List<Integer> ratios) {

        if (foundNumbers.isEmpty()) {
            return ratios;
        }
        FoundNumber test = foundNumbers.get(0);
        List<FoundNumber> remainder = foundNumbers.subList(1, foundNumbers.size());
        Optional<FoundNumber> first = remainder
                .stream()
                .filter(fn -> fn.getSymbolFoundPosition().equals(test.getSymbolFoundPosition()))
                .findFirst();

        if (first.isPresent()) {
            FoundNumber pair = first.get();
            int ratio = test.getNumber() * pair.getNumber();
            ratios.add(ratio);
            remainder = remainder.stream()
                    .filter(fn -> !fn.getSymbolFoundPosition().equals(test.getSymbolFoundPosition()))
                    .collect(Collectors.toList());
        }


        return findGearRatios(remainder, ratios);
    }
}
