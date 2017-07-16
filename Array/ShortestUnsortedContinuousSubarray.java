/*
PROBLEM 581
Given an integer array, you need to find one continuous subarray that if you 
only sort this subarray in ascending order, then the whole array will be sorted 
in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
whole array sorted in ascending order.
--------------------------------------------------------------------------------
Bi-directional search
TIME COMPLEXITY: O(n)
*/

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int begin = nums.length, end = nums.length + 1;
        // from left to right, find the right border
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < max) {
                begin = i;
            }
        }
        // from right to left, find the left border
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > min) {
                end = i;
            }
        }
        return begin - end + 1;
    }
}