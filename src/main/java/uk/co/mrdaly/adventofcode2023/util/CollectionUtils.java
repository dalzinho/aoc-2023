package uk.co.mrdaly.adventofcode2023.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUtils<T> {

    public List<T> collectAndReverse(Stream<T> stream) {
        final List<T> collect = stream.collect(Collectors.toList());
        Collections.reverse(collect);
        return collect;
    }
}
