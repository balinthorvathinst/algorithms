package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class OverlappingIntervallsTest extends BaseTest {

    @Test
    void testBasicOverlappingIntervals() {
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(2, 6),
            Arrays.asList(8, 10),
            Arrays.asList(15, 18)
        );
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 6),
            Arrays.asList(8, 10),
            Arrays.asList(15, 18)
        );
        assertEquals(expected, algorithmService.overlappingIntervalls(input));
    }

    @Test
    void testNonOverlappingIntervals() {
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        assertEquals(expected, algorithmService.overlappingIntervalls(input));
    }

    @Test
    void testAllIntervalsOverlapping() {
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(1, 4),
            Arrays.asList(2, 5),
            Arrays.asList(3, 6)
        );
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 6)
        );
        assertEquals(expected, algorithmService.overlappingIntervalls(input));
    }

    @Test
    void testEmptyList() {
        List<List<Integer>> input = Collections.emptyList();
        List<List<Integer>> expected = Collections.emptyList();
        assertEquals(expected, algorithmService.overlappingIntervalls(input));
    }

    @Test
    void testSingleInterval() {
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(1, 3)
        );
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 3)
        );
        assertEquals(expected, algorithmService.overlappingIntervalls(input));
    }
} 