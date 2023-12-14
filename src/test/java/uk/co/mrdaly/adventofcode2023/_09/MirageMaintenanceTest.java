package uk.co.mrdaly.adventofcode2023._09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mrdaly.adventofcode2023.util.reader.StringFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MirageMaintenanceTest {

    private MirageMaintenance mirageMaintenance;
    private StringFileReader stringFileReader;

    @BeforeEach
    void setup() {
        mirageMaintenance = new MirageMaintenance();
        stringFileReader = new StringFileReader();
    }
    @Test
    void simpleCaseWithJustOnes() {
        List<Integer> input = Arrays.asList(1, 1, 1);
        int actual = mirageMaintenance.partOne(Arrays.asList(input));
        assertEquals(1, actual);
    }

    @Test
    void simpleCaseWithSequence() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        int actual = mirageMaintenance.partOne(Arrays.asList(input));
        assertEquals(4, actual);
    }

    @Test
    void testDOubleListSums() {
        List<Integer> input = Arrays.asList(1, 1, 1);
        List<Integer> input2 = Arrays.asList(1, 2, 3);

        int actual = mirageMaintenance.partOne(Arrays.asList(input, input2));
        assertEquals(5, actual);
    }

    @Test
    void testWithSample()  {
        List<List<Integer>> input = parseInput("_09/sample");
        int actual = mirageMaintenance.partOne(input);
        assertEquals(114, actual);
    }

    private List<List<Integer>> parseInput(String path) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            result = stringFileReader.read(path)
                    .stream()
                    .map(line -> line.split(" "))
                    .map(arr -> Stream.of(arr).map(Integer::parseInt).toList())
                    .toList();
        } catch (IOException e) {
            System.err.println("noooo");
            e.printStackTrace();
        }
        return result;
    }

    @Test
    void testWithInput()  {
        List<List<Integer>> input = parseInput("_09/input");
        int actual = mirageMaintenance.partOne(input);
        assertEquals(1901217887, actual);
    }

    @Test
    void testp2_simpleCase() {
        List<Integer> input = Arrays.asList(1, 1, 1);
        int actual = mirageMaintenance.partTwo(Arrays.asList(input));
        assertEquals(1, actual);
    }

    @Test
    void testp2_DOubleListSums() {
        List<Integer> input = Arrays.asList(1, 1, 1);
        List<Integer> input2 = Arrays.asList(1, 2, 3);

        int actual = mirageMaintenance.partTwo(Arrays.asList(input, input2));
        assertEquals(1, actual);
    }

    @Test
    void exampleForP2() {
        List<Integer> list = Arrays.asList(10, 13, 16, 21, 30, 45);
        int actual = mirageMaintenance.partTwo(Arrays.asList(list));
        assertEquals(5, actual);
    }
    @Test
    void testP2WithSample()  {
        List<List<Integer>> input = parseInput("_09/sample");
        int actual = mirageMaintenance.partTwo(input);
        assertEquals(2, actual);
    }

    @Test
    void sequenceThatFailedForP2() {
        List<Integer> list = Arrays.asList(1,3,6,10,15,21);
        int actual = mirageMaintenance.partTwo(Arrays.asList(list));
        assertEquals(0, actual);
    }

    @Test
    void testP2WithInput()  {
        List<List<Integer>> input = parseInput("_09/input");
        int actual = mirageMaintenance.partTwo(input);
        assertEquals(905, actual);
    }

}
