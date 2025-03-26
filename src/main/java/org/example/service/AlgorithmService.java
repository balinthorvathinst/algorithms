package org.example.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlgorithmService {
    // Reverse a string
    // Write a function that takes a string as input and returns the string reversed.
    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // First unique char
    // Given a string, find the first character that does not repeat and return its index. If it doesn't exist, return -1.
    public int firstUniqueChar(String str) {
        Map<Character, Integer> characterToFrequency = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if (!characterToFrequency.containsKey(currentCharacter)) {
                characterToFrequency.put(currentCharacter, 1);
            } else {
                characterToFrequency.put(currentCharacter, characterToFrequency.get(currentCharacter) + 1);
            }
        }

        int minimalIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (characterToFrequency.get(str.charAt(i)) == 1) {
                minimalIndex = i;
                break;
            }
        }
        return minimalIndex;
    }

    // Overlapping intervalls
    // Given a collection of intervals, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
    public List<List<Integer>> overlappingIntervalls(List<List<Integer>> input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        // Sort intervals by start time
        List<List<Integer>> sortedInput = new ArrayList<>(input);
        for (int i = 0; i < sortedInput.size(); i++) {
            for (int j = 0; j < sortedInput.size() - i - 1; j++) {
                if (sortedInput.get(j).get(0) > sortedInput.get(j + 1).get(0)) {
                    List<Integer> temp = sortedInput.get(j);
                    sortedInput.set(j, sortedInput.get(j + 1));
                    sortedInput.set(j + 1, temp);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentInterval = new ArrayList<>(sortedInput.get(0));

        for (int i = 1; i < sortedInput.size(); i++) {
            if (sortedInput.get(i).get(0) <= currentInterval.get(1)) {
                // Overlapping interval, update the end time if needed
                currentInterval.set(1, Math.max(currentInterval.get(1), sortedInput.get(i).get(1)));
            } else {
                // Non-overlapping interval, add current to result and start new interval
                result.add(new ArrayList<>(currentInterval));
                currentInterval = new ArrayList<>(sortedInput.get(i));
            }
        }
        
        // Add the last interval
        result.add(currentInterval);
        return result;
    }

    // Palindrome
    // Determine if the input string is a palindrome.(Reads the same backwards)
    public boolean isPalindrome(String s) {
        String cleanedS = s.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cleanedS.length(); i++) {
            if (Character.isLetterOrDigit(cleanedS.charAt(i))) {
                stringBuilder.append(cleanedS.charAt(i));
            }
        }

        String processedString = stringBuilder.toString();

        int i = 0;
        int j = processedString.length() - 1;

        while (i < j) {
            if (processedString.charAt(i) != processedString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Two Sum
    // Identify two distinct numbers in the array that add up to the target.
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        boolean found = false;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if (found) {
                        throw new RuntimeException("Already found!");
                    }
                    indices[0] = i;
                    indices[1] = j;
                    found = true;
                }
            }
        }
        return indices;
    }

    // Longest Substring Without Repeating Characters
    // Find the length of the longest substring in a given string that contains no repeating characters.
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndex = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charIndex.containsKey(currentChar)) {
                start = Math.max(start, charIndex.get(currentChar) + 1);
            }
            charIndex.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // Insert interval
    // Insert a new interval into a sorted list of non-overlapping intervals and merge if necessary.
    // Wood cutting
    public List<List<Integer>> insert(List<List<Integer>> intervals, List<Integer> newInterval) {
        boolean found = false;
        List<List<Integer>> finalList = new ArrayList<>();
        Integer first, second;
        // Empty List and one element list
        if(intervals.isEmpty()) {
            finalList.add(newInterval);
        } else if (intervals.size() == 1) {
            if (newInterval.get(0) < intervals.get(0).get(0)) {
                if (newInterval.get(1) < intervals.get(0).get(0)) {
                    finalList.add(List.of(newInterval.get(0), newInterval.get(1)));
                    finalList.add(List.of(intervals.get(0).get(0), intervals.get(0).get(1)));
                } else {
                    finalList.add(List.of(newInterval.get(0), Math.max(intervals.get(0).get(1), newInterval.get(1))));
                }
            } else if (newInterval.get(0) >= intervals.get(0).get(0) && newInterval.get(0) <= intervals.get(0).get(1)) {
                finalList.add(List.of(intervals.get(0).get(0), Math.max(intervals.get(0).get(1), newInterval.get(1))));
            } else {
                finalList.add(List.of(intervals.get(0).get(0), intervals.get(0).get(1)));
                finalList.add(List.of(newInterval.get(0), newInterval.get(1)));
            }
        }

        for (int i = 0; i < intervals.size() - 1; i++) {
            if ((newInterval.get(0) < intervals.get(0).get(0) || ((newInterval.get(0) >= intervals.get(i).get(0)) && (newInterval.get(0) < intervals.get(i + 1).get(0)))) && !found) {
                if (newInterval.get(0) < intervals.get(0).get(0)) {
                    first = newInterval.get(0);
                } else if (newInterval.get(0) <= intervals.get(i).get(1)) {
                    first = intervals.get(i).get(0);
                } else {
                    first = newInterval.get(0);
                    finalList.add(List.of(intervals.get(i).get(0), intervals.get(i).get(1)));
                }
                for (int j = i; j < intervals.size(); j++) {
                    if(newInterval.get(1) < intervals.get(j).get(1) && !found) {
                        if (newInterval.get(1) < intervals.get(j).get(0)) {
                            second = newInterval.get(1);
                            found = true;
                            finalList.add(List.of(first, second));
                            finalList.add(List.of(intervals.get(j).get(0), intervals.get(j).get(1)));
                        } else {
                            second = intervals.get(j).get(1);
                            finalList.add(List.of(first, second));
                            found = true;
                        }
                    } else if (found) {
                        finalList.add(List.of(intervals.get(j).get(0), intervals.get(j).get(1)));
                    }
                }
                if (!found) {
                    finalList.add(List.of(first, newInterval.get(1)));
                }
            } else if (!found) {
                finalList.add(List.of(intervals.get(i).get(0), intervals.get(i).get(1)));
            } else {
                break;
            }
        }
        if (!found && intervals.size() != 1 && !intervals.isEmpty()) {
            if (newInterval.get(0) > intervals.get(intervals.size() - 1).get(1)) {
                finalList.add(List.of(intervals.get(intervals.size() - 1).get(0), intervals.get(intervals.size() - 1).get(1)));
                finalList.add(List.of(newInterval.get(0), newInterval.get(1)));
            } else {
                finalList.add(List.of(intervals.get(0).get(0), Math.max(newInterval.get(0), intervals.get(intervals.size() - 1).get(1))));
            }
        }
        return finalList;
    }

    // Good solution
    public List<List<Integer>> insert2(List<List<Integer>> intervals, List<Integer> newInterval) {
        List<List<Integer>> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.size();

        // Add all intervals ending before newInterval starts
        while (i < n && intervals.get(i).get(1) < newInterval.get(0)) {
            merged.add(intervals.get(i));
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals.get(i).get(0) <= newInterval.get(1)) {
            newInterval.set(0, Math.min(newInterval.get(0), intervals.get(i).get(0)));
            newInterval.set(1, Math.max(newInterval.get(1), intervals.get(i).get(1)));
            i++;
        }
        merged.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            merged.add(intervals.get(i));
            i++;
        }

        return merged;
    }

    // Max
    public int findMaximum(int[] nums) {
        if (nums.length != 0) {
            int max = nums[0];
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }
        return 0;
    }

    // Sum all elements in an array
    public int sumArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    // Remove duplicates
    public int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // Count vowels
    public int countVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(Character.toLowerCase(c))) {
                count++;
            }
        }
        return count;
    }

    // First unique character
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // First pass: count occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Second pass: find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }
} 