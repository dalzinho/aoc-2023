package uk.co.mrdaly.adventofcode2023._06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitForItTest {

    private StringFileReader stringFileReader;
    private WaitForIt waitForIt;

    @BeforeEach
    void setup() {
        stringFileReader = new StringFileReader();
        waitForIt = new WaitForIt();
    }

    @Test
    void testP1ZeroZero() {
        List<String> list = Arrays.asList("Time:  7", "Distance: 9");
        long actual = waitForIt.partOne(list);
        assertEquals(4, actual);
    }

    @Test
    void testP1Sample() throws IOException {
        List<String> list = stringFileReader.read("_06/sample");
        long actual = waitForIt.partOne(list);
        assertEquals(288, actual);
    }
    @Test
    void testP1() throws IOException {
        List<String> list = stringFileReader.read("_06/input");
        long actual = waitForIt.partOne(list);
        assertEquals(288, actual);
    }

    @Test
    void partTwo() {
        long l = waitForIt.partTwo(40828492, 233101111101487l);
        assertEquals(1, l);
    }


}