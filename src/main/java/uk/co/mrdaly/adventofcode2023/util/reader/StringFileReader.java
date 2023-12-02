package uk.co.mrdaly.adventofcode2023.util.reader;

import java.io.IOException;
import java.util.List;

public class StringFileReader extends FileReader<String> {

    public List<String> read(String path) throws IOException {
        return super.readLines(path);
    }
}
