package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class InsertTest extends BaseTest {

    @Test
    void testInsert() {
        // Test case 1: Basic insertion
        List<List<Integer>> intervals1 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(6, 9)
        );
        List<Integer> newInterval1 = Arrays.asList(2, 5);
        List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(1, 5),
            Arrays.asList(6, 9)
        );
        assertEquals(expected1, algorithmService.insert(intervals1, newInterval1));

        // Test case 2: Insert into empty list
        List<List<Integer>> intervals2 = new ArrayList<>();
        List<Integer> newInterval2 = Arrays.asList(1, 3);
        List<List<Integer>> expected2 = Arrays.asList(
            Arrays.asList(1, 3)
        );
        assertEquals(expected2, algorithmService.insert(intervals2, newInterval2));

        // Test case 3: Insert at the beginning
        List<List<Integer>> intervals3 = Arrays.asList(
            Arrays.asList(2, 4),
            Arrays.asList(5, 7)
        );
        List<Integer> newInterval3 = Arrays.asList(0, 1);
        List<List<Integer>> expected3 = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(2, 4),
            Arrays.asList(5, 7)
        );
        assertEquals(expected3, algorithmService.insert(intervals3, newInterval3));

        // Test case 4: Insert at the end
        List<List<Integer>> intervals4 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(4, 6)
        );
        List<Integer> newInterval4 = Arrays.asList(7, 8);
        List<List<Integer>> expected4 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(4, 6),
            Arrays.asList(7, 8)
        );
        assertEquals(expected4, algorithmService.insert(intervals4, newInterval4));

        // Test case 5: Insert overlapping multiple intervals
        List<List<Integer>> intervals5 = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 5),
            Arrays.asList(6, 7),
            Arrays.asList(8, 10),
            Arrays.asList(12, 16)
        );
        List<Integer> newInterval5 = Arrays.asList(4, 9);
        List<List<Integer>> expected5 = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 10),
            Arrays.asList(12, 16)
        );
        assertEquals(expected5, algorithmService.insert(intervals5, newInterval5));
    }
} 