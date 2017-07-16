/*
PROBLEM 611
Given an array consists of non-negative integers, your task is to count the 
number of triplets chosen from the array that can make triangles if we take 
them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
--------------------------------------------------------------------------------
two pointers idea!
TIME COMPLEXITY: O(n^2)
SPACE COMPLEXITY: O(1)
*/

public class Solution {
    public int triangleNumber(int[] nums) {
        int i = nums.length - 1;
        Arrays.sort(nums);
        
        int count = 0;
        while (i >= 2) {
            int r = i - 1, l = 0;
            while (r > l) {
                if (nums[r] + nums[l] > nums[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
            i--;
        }
        return count;
    }
}