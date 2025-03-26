package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharTest {

    @Test
    void testFirstUniqueChar() {
        // Test case 1: Normal string with unique character
        assertEquals(0, Main.firstUniqueChar("leetcode"));
        
        // Test case 2: String with no unique characters
        assertEquals(-1, Main.firstUniqueChar("aabb"));
        
        // Test case 3: Empty string
        assertEquals(-1, Main.firstUniqueChar(""));
        
        // Test case 4: Single character
        assertEquals(0, Main.firstUniqueChar("a"));
        
        // Test case 5: String with spaces
        assertEquals(0, Main.firstUniqueChar("a b c"));
        
        // Test case 6: String with special characters
        assertEquals(0, Main.firstUniqueChar("!@#$"));
    }
} 