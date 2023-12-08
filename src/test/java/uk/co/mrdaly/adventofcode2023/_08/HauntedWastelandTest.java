package uk.co.mrdaly.adventofcode2023._08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HauntedWastelandTest {

    private StringFileReader stringFileReader;
    private HauntedWasteland hauntedWasteland;

    @BeforeEach
    void setup() {
        stringFileReader = new StringFileReader();
        hauntedWasteland = new HauntedWasteland();
    }

    @Test
    void testSample() throws IOException {
        List<String> input = stringFileReader.read("_08/sample");
        int actual = hauntedWasteland.partOne(input);
        assertEquals(2, actual);
    }

    @Test
    void testSecondSample_needsToLoopInstructions() throws IOException {
        List<String> input = stringFileReader.read("_08/sample2");
        int actual = hauntedWasteland.partOne(input);
        assertEquals(6, actual);
    }

    @Test
    void testPArtOne() throws IOException {
        List<String> input = stringFileReader.read("_08/input");
        int actual = hauntedWasteland.partOne(input);
        assertEquals(19099, actual);
    }

    @Test
    void test_p2_Sample() throws IOException {
        List<String> input = stringFileReader.read("_08/sample3");
        long actual = hauntedWasteland.partTwo(input);
        assertEquals(6, actual);
    }

    @Test
    void testPArtTwo() throws IOException {
        List<String> input = stringFileReader.read("_08/input");
        long actual = hauntedWasteland.partTwo(input);
        assertEquals(17099847107071L, actual);
    }
}