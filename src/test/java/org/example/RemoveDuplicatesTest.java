package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest extends BaseTest {

    @Test
    void testRemoveDuplicates() {
        // Test case 1: Basic case with duplicates
        assertArrayEquals(new int[]{1, 2, 3}, algorithmService.removeDuplicates(new int[]{1, 2, 2, 3, 3, 3}));
        
        // Test case 2: Array with no duplicates
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, algorithmService.removeDuplicates(new int[]{1, 2, 3, 4, 5}));
        
        // Test case 3: Array with all same elements
        assertArrayEquals(new int[]{1}, algorithmService.removeDuplicates(new int[]{1, 1, 1, 1, 1}));
        
        // Test case 4: Array with negative numbers
        assertArrayEquals(new int[]{-1, -2, -3}, algorithmService.removeDuplicates(new int[]{-1, -2, -2, -3, -3}));
        
        // Test case 5: Array with single element
        assertArrayEquals(new int[]{1}, algorithmService.removeDuplicates(new int[]{1}));
        
        // Test case 6: Empty array
        assertArrayEquals(new int[]{}, algorithmService.removeDuplicates(new int[]{}));
        
        // Test case 7: Array with zeros
        assertArrayEquals(new int[]{0}, algorithmService.removeDuplicates(new int[]{0, 0, 0}));
    }
} 