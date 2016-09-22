package service;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by enda1n on 22.09.2016.
 */
public class SimpleTest {

    @Test
    public void test() {
        long count = Arrays.asList("java java scala groovy java").stream()
                .map(String::toLowerCase)
                .flatMap((line) -> Arrays.stream(line.split(" ")))
                .count();

        System.out.println(count);
    }
}
