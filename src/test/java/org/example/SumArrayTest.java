package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumArrayTest {

    @Test
    void testSumArray() {
        // Test case 1: Basic case with positive numbers
        assertEquals(15, Main.sumArray(new int[]{1, 2, 3, 4, 5}));
        
        // Test case 2: Array with negative numbers
        assertEquals(-15, Main.sumArray(new int[]{-1, -2, -3, -4, -5}));
        
        // Test case 3: Array with mixed numbers
        assertEquals(0, Main.sumArray(new int[]{-1, 1, -2, 2}));
        
        // Test case 4: Array with zeros
        assertEquals(0, Main.sumArray(new int[]{0, 0, 0, 0}));
        
        // Test case 5: Array with single element
        assertEquals(5, Main.sumArray(new int[]{5}));
        
        // Test case 6: Empty array
        assertEquals(0, Main.sumArray(new int[]{}));
        
        // Test case 7: Array with large numbers
        assertEquals(3000000, Main.sumArray(new int[]{1000000, 1000000, 1000000}));
    }
} 