package uk.co.mrdaly.adventofcode2023._03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringMatrixFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GearRatiosTest {

    private GearRatios gearRatios;
    private StringMatrixFileReader stringMatrixFileReader;
    @BeforeEach
    void setup() {
        gearRatios = new GearRatios();
        stringMatrixFileReader = new StringMatrixFileReader();
    }

    @Test
    void partOneSimpleCase() {
        List<List<String>> input = new ArrayList<>();
        input.add(List.of("4","6","7",".",".","1","1","4",".","."));
        input.add(List.of(".",".",".","*",".",".",".",".",".","."));

        int actual = gearRatios.partOne(input);
        assertEquals(467, actual);
    }

    @Test
    void partOneWithSample() throws IOException {
        List<List<String>> sample = stringMatrixFileReader.read("_03/1-sample");
        int actual = gearRatios.partOne(sample);
        assertEquals(4361, actual);
    }

    @Test
    void partOne() throws IOException {
        List<List<String>> sample = stringMatrixFileReader.read("_03/1");
        int actual = gearRatios.partOne(sample);
        assertEquals(535078, actual);
    }

    @Test
    void partTwoSimpleCase() {
        List<List<String>> input = Stream.of("467..114..", "...*......", "..35..633.")
                .map(s -> s.split(""))
                .map(Arrays::asList)
                .collect(Collectors.toList());
        int actual = gearRatios.partTwo(input);
        assertEquals(16345, actual);
    }

    @Test
    void partTwoWithSample() throws IOException {
        List<List<String>> sample = stringMatrixFileReader.read("_03/1-sample");
        int actual = gearRatios.partTwo(sample);
        assertEquals(467835, actual);
    }

    @Test
    void partTwo() throws IOException {
        List<List<String>> sample = stringMatrixFileReader.read("_03/1");
        int actual = gearRatios.partTwo(sample);
        assertEquals(75312571, actual);
    }
}