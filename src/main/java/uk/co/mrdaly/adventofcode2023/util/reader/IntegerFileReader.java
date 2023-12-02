package uk.co.mrdaly.adventofcode2023.util.reader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerFileReader extends FileReader<Integer> {

    public List<Integer> read(String path) throws IOException {
        return super.readLines(path)
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
