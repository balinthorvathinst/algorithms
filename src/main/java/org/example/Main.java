package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(countVowels("Hello Worldaaaa!"));
    }

    // Reverse a string
    // Write a function that takes a string as input and returns the string reversed.
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // First unique char
    // Given a string, find the first character that does not repeat and return its index. If it doesn't exist, return -1.


    public static int firstUniqueChar(String str) {
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
    public static List<List<Integer>> overlappingIntervalls(List<List<Integer>> input) {
        List<Integer> temporaryList;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - i - 1; j++) {
                if (input.get(j).get(0) > input.get(j + 1).get(0)) {
                    temporaryList = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temporaryList);
                }
            }
        }

        temporaryList = input.get(0);
        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i + 1).get(0) <= temporaryList.get(1)) {
                if (temporaryList.get(1) < input.get(i + 1).get(1)) {
                    temporaryList.set(1, input.get(i + 1).get(1));
                }
            } else {
                finalList.add(new ArrayList<>(temporaryList));
                temporaryList.set(0, input.get(i + 1).get(0));
                temporaryList.set(1, input.get(i + 1).get(1));
            }
        }
        finalList.add(new ArrayList<>(temporaryList));
        return finalList;
    }

    // Palindrome
    // Determine if the input string is a palindrome.(Reads the same backwards)
    public static boolean isPalindrome(String s) {
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
    public static int[] twoSum(int[] nums, int target) {
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
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j;
        int maxLength = 0;
        StringBuilder temporary = new StringBuilder();

        while (i < s.length() && s.length() - i > maxLength) {
            j = i;
            while (j < s.length() && !temporary.toString().contains(String.valueOf(s.charAt(j)))) {
                temporary.append(s.charAt(j));
                j++;
            }
            if (maxLength < temporary.length()) {
                maxLength = temporary.length();
            }
            temporary = new StringBuilder();
            i++;
        }
        return maxLength;
    }

    // Insert interval
    // Insert a new interval into a sorted list of non-overlapping intervals and merge if necessary.
    // Wood cutting
    public static List<List<Integer>> insert(List<List<Integer>> intervals, List<Integer> newInterval) {
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
    public static List<List<Integer>> insert2(List<List<Integer>> intervals, List<Integer> newInterval) {
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
    public static int findMaximum(int[] nums) {
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
    public static int sumArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    // Remove duplicates
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // Count vowels
    public static int countVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        return count;
    }

    // Remove element
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next insertion position

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
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