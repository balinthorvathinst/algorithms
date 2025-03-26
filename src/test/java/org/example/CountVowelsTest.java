package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountVowelsTest {

    @Test
    void testCountVowels() {
        // Test case 1: Basic case with vowels
        assertEquals(3, Main.countVowels("Hello World"));
        
        // Test case 2: String with no vowels
        assertEquals(0, Main.countVowels("rhythm"));
        
        // Test case 3: Empty string
        assertEquals(0, Main.countVowels(""));
        
        // Test case 4: String with all vowels
        assertEquals(5, Main.countVowels("aeiou"));
        
        // Test case 5: String with mixed case vowels
        assertEquals(2, Main.countVowels("hEllO"));
        
        // Test case 6: String with spaces
        assertEquals(5, Main.countVowels("a e i o u"));
        
        // Test case 7: String with special characters
        assertEquals(0, Main.countVowels("h@ll0 w0rld!"));
        
        // Test case 8: String with repeated vowels
        assertEquals(5, Main.countVowels("bookkeeper"));
    }
} 