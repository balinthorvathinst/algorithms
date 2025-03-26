package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void testReverseString() {
        // Test case 1: Normal string
        assertEquals("dlroW olleH", Main.reverseString("Hello World"));
        
        // Test case 2: Empty string
        assertEquals("", Main.reverseString(""));
        
        // Test case 3: Single character
        assertEquals("a", Main.reverseString("a"));
        
        // Test case 4: Palindrome
        assertEquals("radar", Main.reverseString("radar"));
        
        // Test case 5: String with spaces
        assertEquals("   ", Main.reverseString("   "));
        
        // Test case 6: String with special characters
        assertEquals("!@#$%", Main.reverseString("%$#@!"));
    }
} 