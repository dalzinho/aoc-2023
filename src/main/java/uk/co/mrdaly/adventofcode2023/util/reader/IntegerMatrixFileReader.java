package uk.co.mrdaly.adventofcode2023.util.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerMatrixFileReader extends FileReader<List<Integer>> {

    @Override
    public List<List<Integer>> read(String path) throws IOException {
        List<List<Integer>> list = new ArrayList<>();

        for (String s : readLines(path)) {
            final String[] split = s.split("");
            final List<Integer> collect = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
            list.add(collect);
        }

        return list;
    }
}
