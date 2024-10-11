package org.example;

import java.util.*;

public class Main {


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcdefedcbak"));
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


//    public static int firstUniqueChar(String str) {
//        Map<Character, Integer> characterToFrequency = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char currentCharacter = str.charAt(i);
//            if (!characterToFrequency.containsKey(currentCharacter)) {
//                characterToFrequency.put(currentCharacter, 1);
//            } else {
//                characterToFrequency.put(currentCharacter, characterToFrequency.get(currentCharacter) + 1);
//            }
//        }
//
//        int minimalIndex = -1;
//        for (int i = 0; i < str.length(); i++) {
//            if (characterToFrequency.get(str.charAt(i)) == 1) {
//                minimalIndex = i;
//                break;
//            }
//        }
//        return minimalIndex;
//    }
//
//    // Overlapping intervalls
//    // Given a collection of intervals, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
//    public static List<List<Integer>> overlappingIntervalls(List<List<Integer>> input) {
//        List<Integer> temporaryList;
//        for (int i = 0; i < input.size(); i++) {
//            for (int j = 0; j < input.size() - i - 1; j++) {
//                if(input.get(j).get(0) > input.get(j + 1).get(0)) {
//                    temporaryList = input.get(j);
//                    input.set(j, input.get(j + 1));
//                    input.set(j + 1, temporaryList);
//                }
//            }
//        }
//
//        temporaryList = input.get(0);
//        List<List<Integer>> finalList = new ArrayList<>();
//        for (int i = 0; i < input.size() - 1; i++) {
//            if(input.get(i + 1).get(0) <= temporaryList.get(1)) {
//                if(temporaryList.get(1) < input.get(i + 1).get(1)) {
//                    temporaryList.set(1, input.get(i + 1).get(1));
//                }
//            } else {
//                finalList.add(new ArrayList<>(temporaryList));
//                temporaryList.set(0, input.get(i + 1).get(0));
//                temporaryList.set(1, input.get(i + 1).get(1));
//            }
//        }
//        finalList.add(new ArrayList<>(temporaryList));
//        return finalList;
//    }
//
//    // Palindrome
//    // Determine if the input string is a palindrome.(Reads the same backwards)
//    public static boolean isPalindrome(String s) {
//        String cleanedS = s.toLowerCase();
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < cleanedS.length(); i++) {
//            if (Character.isLetterOrDigit(cleanedS.charAt(i))) {
//                stringBuilder.append(cleanedS.charAt(i));
//            }
//        }
//
//        String processedString = stringBuilder.toString();
//
//        int i = 0;
//        int j = processedString.length() - 1;
//
//        while(i < j) {
//            if(processedString.charAt(i) != processedString.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//    // Two Sum
//    // Identify two distinct numbers in the array that add up to the target.
//    public static int[] twoSum(int[] nums, int target) {
//        int[] indices = new int[2];
//        boolean found = false;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    if (found) {
//                        throw new RuntimeException("Already found!");
//                    }
//                    indices[0] = i;
//                    indices[1] = j;
//                    found = true;
//                }
//            }
//        }
//        return indices;
//    }
//
//    // Longest Substring Without Repeating Characters
//    // Find the length of the longest substring in a given string that contains no repeating characters.
//    public static int lengthOfLongestSubstring(String s) {
//        int i = 0;
//        int j;
//        int maxLength = 0;
//        StringBuilder temporary = new StringBuilder();
//
//        while(i < s.length() && s.length() - i > maxLength) {
//            j = i;
//            while(j < s.length() && !temporary.toString().contains(String.valueOf(s.charAt(j)))) {
//                temporary.append(s.charAt(j));
//                j++;
//            }
//            if(maxLength < temporary.length()) {
//                maxLength = temporary.length();
//            }
//            temporary = new StringBuilder();
//            i++;
//        }
//        return maxLength;
//    }
//
//    // Insert interval
//    // Insert a new interval into a sorted list of non-overlapping intervals and merge if necessary.
//    public class IntervalInsertion {
//        public int[][] insert(int[][] intervals, int[] newInterval) {
//            int[] intervalInsert = new int[2];
//            for (int i = 0; i < intervals.length; i++) {
//                if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]) {
//                    intervalInsert[0] = Math.min(intervals[i][0], newInterval[0]);
//                    if (newInterval[1] <= intervals[i][1]) {
//
//                    } else if (newInterval[1] < intervals[i + 1][0]) {
//                        intervalInsert[1] = newInterval[1];
//                        intervals[i][0] = intervalInsert[0];
//                        intervals[i][1] = intervalInsert[1];
//                    }
//                }
//            }
//            return null;
//        }
//    }

}