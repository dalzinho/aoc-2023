package uk.co.mrdaly.adventofcode2023._02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CubeConundrumTest {

    private StringFileReader stringFileReader = new StringFileReader();

    private CubeConundrum cubeConundrum;

    @BeforeEach
    void setup() {
        cubeConundrum = new CubeConundrum();
    }

    @Test
    public void testWithSample() throws IOException {
        List<String> sample = stringFileReader.read("_02/1-sample");
        int actual = cubeConundrum.partOne(sample, 12, 13, 14);
        assertEquals(8, actual);
    }

    @Test
    public void partOneForReals() throws IOException {
        List<String> data = stringFileReader.read("_02/1");
        int actual = cubeConundrum.partOne(data, 12, 13, 14);
        assertEquals(2727, actual);
    }

    @Test
    public void partTwoSample() throws Exception {
        List<String> sample = stringFileReader.read("_02/1-sample");
        int actual = cubeConundrum.partTwo(sample);
        assertEquals(2286, actual);
    }

    @Test
    public void partTwo() throws Exception{
        List<String> data = stringFileReader.read("_02/1");
        int actual = cubeConundrum.partTwo(data);
        assertEquals(0, actual);

    }
}