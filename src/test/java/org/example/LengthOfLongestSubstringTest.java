package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest extends BaseTest {

    @Test
    void testBasicCase() {
        assertEquals(3, algorithmService.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(1, algorithmService.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, algorithmService.lengthOfLongestSubstring(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, algorithmService.lengthOfLongestSubstring("a"));
    }

    @Test
    void testStringWithSpaces() {
        assertEquals(3, algorithmService.lengthOfLongestSubstring("a b c d e"));
    }

    @Test
    void testStringWithSpecialCharacters() {
        assertEquals(3, algorithmService.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void testStringWithRepeatedCharacters() {
        assertEquals(3, algorithmService.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void testStringWithNumbers() {
        assertEquals(4, algorithmService.lengthOfLongestSubstring("1234"));
    }
} 