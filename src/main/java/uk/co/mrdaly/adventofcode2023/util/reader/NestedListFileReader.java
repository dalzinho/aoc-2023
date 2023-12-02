package uk.co.mrdaly.adventofcode2023.util.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NestedListFileReader extends FileReader<List> {

    @Override
    List<List> read(String path) throws IOException {
        List<List> result = new ArrayList<List>();
        final List<String> strings = readLines(path);
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).isEmpty()) {
                continue;
            }

            List list = new ArrayList();




            result.add(list);


        }
        return null;
    }
}
