package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testTwoSum() {
        // Test case 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = Main.twoSum(nums1, target1);
        assertArrayEquals(new int[]{0, 1}, result1);

        // Test case 2: Target with negative numbers
        int[] nums2 = {-1, -2, -3, -4, -5};
        int target2 = -8;
        int[] result2 = Main.twoSum(nums2, target2);
        assertArrayEquals(new int[]{2, 4}, result2);

        // Test case 3: Target with mixed numbers
        int[] nums3 = {-3, 4, 3, 90};
        int target3 = 0;
        int[] result3 = Main.twoSum(nums3, target3);
        assertArrayEquals(new int[]{0, 2}, result3);

        // Test case 4: Target with duplicate numbers
        int[] nums4 = {3, 3};
        int target4 = 6;
        int[] result4 = Main.twoSum(nums4, target4);
        assertArrayEquals(new int[]{0, 1}, result4);

        // Test case 5: Target with zero
        int[] nums5 = {0, 4, 3, 0};
        int target5 = 0;
        int[] result5 = Main.twoSum(nums5, target5);
        assertArrayEquals(new int[]{0, 3}, result5);
    }
} 