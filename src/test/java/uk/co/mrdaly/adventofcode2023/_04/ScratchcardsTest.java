package uk.co.mrdaly.adventofcode2023._04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

class ScratchcardsTest {

    private StringFileReader stringFileReader;
    private Scratchcards scratchcards;

    @BeforeEach
    void setup() {
        stringFileReader = new StringFileReader();
        scratchcards = new Scratchcards();
    }

    @Test
    void partOneSimpleCase() {
        String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        int actual = scratchcards.partOne(singletonList(input));
        assertEquals(8, actual);
    }

    @Test
    void partOneSample() throws IOException {
        List<String> input = stringFileReader.read("_04/sample");
        int actual = scratchcards.partOne(input);
        assertEquals(13, actual);
    }

    @Test
    void partOne() throws IOException {
        List<String> input = stringFileReader.read("_04/input");
        int actual = scratchcards.partOne(input);
        assertEquals(25571, actual);
    }

    @Test
    void partTwoSimpleCase() throws IOException {
        List<String> input = stringFileReader.read("_04/sample");
        int actual = scratchcards.partTwo(input);
        assertEquals(30, actual);
    }
    @Test
    void partTwo() throws IOException {
        List<String> input = stringFileReader.read("_04/input");
        int actual = scratchcards.partTwo(input);
        assertEquals(8805731, actual);
    }

}