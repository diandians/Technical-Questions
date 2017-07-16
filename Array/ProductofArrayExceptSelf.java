/*
PROBLEM 238
Given an array of n integers where n > 1, nums, return an array output such that
 output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does 
not count as extra space for the purpose of space complexity analysis.)
--------------------------------------------------------------------------------
TIME COMPLEXITY: O(n)
*/

// SPACE COMPLEXITY: O(n)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];
        temp1[0] = 1;
        temp2[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            temp1[i] = temp1[i - 1] * nums[i - 1];
            temp2[nums.length - i - 1] = temp2[nums.length - i] * nums[nums.length - i];  
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp1[i] * temp2[i];
        }
        
        return result;
    }
}

// SPACE COMPLEXITY: O(1)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}