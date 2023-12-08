package uk.co.mrdaly.adventofcode2023.util;

import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.List;

public class Maths {

    public static long lcm(List<Long> ints) {

        return recurseLcm(ints.get(0), ints.subList(1, ints.size()));
    }

    private static long recurseLcm(long result, List<Long> longs) {
        if (longs.isEmpty()) {
            return result;
        }

        long lcm = ArithmeticUtils.lcm(result, longs.get(0));
        return recurseLcm(lcm, longs.subList(1, longs.size()));

    }


}
