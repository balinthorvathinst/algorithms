package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {

    @Test
    void testIsPalindrome() {
        // Test case 1: Simple palindrome
        assertTrue(Main.isPalindrome("A man, a plan, a canal: Panama"));
        
        // Test case 2: Non-palindrome
        assertFalse(Main.isPalindrome("race a car"));
        
        // Test case 3: Empty string
        assertTrue(Main.isPalindrome(""));
        
        // Test case 4: Single character
        assertTrue(Main.isPalindrome("a"));
        
        // Test case 5: Palindrome with numbers
        assertTrue(Main.isPalindrome("12321"));
        
        // Test case 6: Palindrome with special characters
        assertTrue(Main.isPalindrome("A man, a plan, a canal: Panama"));
        
        // Test case 7: Palindrome with spaces
        assertTrue(Main.isPalindrome("never odd or even"));
        
        // Test case 8: Non-palindrome with spaces
        assertFalse(Main.isPalindrome("hello world"));
    }
} 