package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindMaximumTest extends BaseTest {

    @Test
    void testFindMaximum() {
        // Test case 1: Basic case with positive numbers
        assertEquals(5, algorithmService.findMaximum(new int[]{1, 2, 3, 4, 5}));
        
        // Test case 2: Array with negative numbers
        assertEquals(-1, algorithmService.findMaximum(new int[]{-5, -3, -1, -2, -4}));
        
        // Test case 3: Array with mixed numbers
        assertEquals(10, algorithmService.findMaximum(new int[]{-1, 5, 10, -3, 8}));
        
        // Test case 4: Array with duplicate maximum values
        assertEquals(5, algorithmService.findMaximum(new int[]{5, 5, 5, 5, 5}));
        
        // Test case 5: Array with single element
        assertEquals(1, algorithmService.findMaximum(new int[]{1}));
        
        // Test case 6: Array with zero
        assertEquals(0, algorithmService.findMaximum(new int[]{0}));
        
        // Test case 7: Array with large numbers
        assertEquals(1000000, algorithmService.findMaximum(new int[]{1000000, 999999, 888888}));
    }
} 