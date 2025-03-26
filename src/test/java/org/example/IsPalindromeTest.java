package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest extends BaseTest {

    @Test
    void testIsPalindrome() {
        // Test case 1: Simple palindrome
        assertTrue(algorithmService.isPalindrome("A man, a plan, a canal: Panama"));
        
        // Test case 2: Non-palindrome
        assertFalse(algorithmService.isPalindrome("race a car"));
        
        // Test case 3: Empty string
        assertTrue(algorithmService.isPalindrome(""));
        
        // Test case 4: Single character
        assertTrue(algorithmService.isPalindrome("a"));
        
        // Test case 5: Palindrome with numbers
        assertTrue(algorithmService.isPalindrome("12321"));
        
        // Test case 6: Palindrome with special characters
        assertTrue(algorithmService.isPalindrome("A man, a plan, a canal: Panama"));
        
        // Test case 7: Palindrome with spaces
        assertTrue(algorithmService.isPalindrome("never odd or even"));
        
        // Test case 8: Non-palindrome with spaces
        assertFalse(algorithmService.isPalindrome("hello world"));
    }
} 