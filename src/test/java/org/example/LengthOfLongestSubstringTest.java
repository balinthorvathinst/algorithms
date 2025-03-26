package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    @Test
    void testBasicCase() {
        assertEquals(3, Main.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(1, Main.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, Main.lengthOfLongestSubstring(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, Main.lengthOfLongestSubstring("a"));
    }

    @Test
    void testStringWithSpaces() {
        assertEquals(3, Main.lengthOfLongestSubstring("a b c d e"));
    }

    @Test
    void testStringWithSpecialCharacters() {
        assertEquals(3, Main.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void testStringWithRepeatedCharacters() {
        assertEquals(3, Main.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void testStringWithNumbers() {
        assertEquals(4, Main.lengthOfLongestSubstring("1234"));
    }
} 