package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest extends BaseTest {

    @Test
    void testReverseString() {
        // Test case 1: Normal string
        assertEquals("dlroW olleH", algorithmService.reverseString("Hello World"));
        
        // Test case 2: Empty string
        assertEquals("", algorithmService.reverseString(""));
        
        // Test case 3: Single character
        assertEquals("a", algorithmService.reverseString("a"));
        
        // Test case 4: Palindrome
        assertEquals("radar", algorithmService.reverseString("radar"));
        
        // Test case 5: String with spaces
        assertEquals("   ", algorithmService.reverseString("   "));
        
        // Test case 6: String with special characters
        assertEquals("!@#$%", algorithmService.reverseString("%$#@!"));
    }
} 