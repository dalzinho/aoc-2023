package uk.co.mrdaly.adventofcode2023.util.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatrixFileReader extends FileReader<List<String>> {
    @Override
    public List<List<String>> read(String path) throws IOException {
        List<List<String>> list = new ArrayList<>();

        for (String s : readLines(path)) {
            final String[] split = s.split("");
            List<String> collect = Arrays.asList(split);
            list.add(collect);
        }

        return list;
    }
}
