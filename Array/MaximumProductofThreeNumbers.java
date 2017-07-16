/*
Given an integer array, find three numbers whose product is maximum and output 
the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in 
the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 
32-bit signed integer.
--------------------------------------------------------------------------------
TIME COMPLEXITY: O(n)
*/

public class Solution {
    public int maximumProduct(int[] nums) {
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]){
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }
            
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}