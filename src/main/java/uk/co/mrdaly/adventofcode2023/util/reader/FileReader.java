package uk.co.mrdaly.adventofcode2023.util.reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
public abstract class FileReader<T> {

    abstract List<T> read(String path) throws IOException;

    protected List<String> readLines(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        return Files.readAllLines(resource.getFile().toPath());
    }
}
