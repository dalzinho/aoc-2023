package uk.co.mrdaly.adventofcode2023._1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrebuchetTest {

    private List<String> sample = Arrays.asList("1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet");

    private StringFileReader stringFileReader = new StringFileReader();
    private List<String> input;

    private Trebuchet trebuchet;

    @BeforeEach
    void setup() {
        trebuchet = new Trebuchet();
    }

    @Test
    void partOneWithOneLine() {
        int actual = trebuchet.partOne(Collections.singletonList("1abc2"));
        assertEquals(12, actual);
    }

    @Test
    void partOneWithSample() {
        final int actual = trebuchet.partOne(sample);
        assertEquals(142, actual);
    }

    @Test
    void partOneWithInput() throws IOException {
        List<String> input = stringFileReader.read("_01/_01-1");
        int actual = trebuchet.partOne(input);
        assertEquals(53921, actual);
    }

    @Test
    void partTwoWithOneEntryWordFirstWordLast() {
        int actual = trebuchet.partTwo(Collections.singletonList("two1nine"));
        assertEquals(29, actual);
    }

    @Test
    void partTwoOverlappingWords() {
        String input = "eightwothree";
        int actual = trebuchet.partTwo(Collections.singletonList(input));
        assertEquals(83, actual);
    }

    @Test
    void partTwoOverlappingAffectingLast() {
        String input = "1twone";
        int actual = trebuchet.partTwo(Collections.singletonList(input));
        assertEquals(11, actual);
    }

    @Test
    void partTwoOverlappingAffectingLastButNotTheVeryLast() {
        String input = "1twonexcv";
        int actual = trebuchet.partTwo(Collections.singletonList(input));
        assertEquals(11, actual);
    }

    @Test
    void partTwoWithManyEntries() throws IOException {
        List<String> input = stringFileReader.read("_01/_01-2-sample");
        int actual = trebuchet.partTwo(input);
        assertEquals(281, actual);
    }

    @Test
    void partTwo() throws IOException {
        List<String> input = stringFileReader.read("_01/_01-1");
        int actual = trebuchet.partTwo(input);
        assertEquals(0, actual);
    }
}