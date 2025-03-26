package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharTest extends BaseTest {

    @Test
    void testFirstUniqueChar() {
        // Test case 1: Normal string with unique character
        assertEquals(0, algorithmService.firstUniqueChar("leetcode"));
        
        // Test case 2: String with no unique characters
        assertEquals(-1, algorithmService.firstUniqueChar("aabb"));
        
        // Test case 3: Empty string
        assertEquals(-1, algorithmService.firstUniqueChar(""));
        
        // Test case 4: Single character
        assertEquals(0, algorithmService.firstUniqueChar("a"));
        
        // Test case 5: String with spaces
        assertEquals(0, algorithmService.firstUniqueChar("a b c"));
        
        // Test case 6: String with special characters
        assertEquals(0, algorithmService.firstUniqueChar("!@#$"));
    }
} 