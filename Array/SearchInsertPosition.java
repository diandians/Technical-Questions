/*
PROBLEM 35
Given a sorted array and a target value, return the index if the target is 
found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
--------------------------------------------------------------------------------
TIME COMPLEXITY: O(logn) (binary search)
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right - left)/2 + left;
            // corner case: length is one
            if (right == left) {
                return target <= nums[mid]? mid: mid + 1;
            }
            if (target > nums[mid]) {
                if (target < nums[mid + 1]) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return target < nums[0]? 0: nums.length;
    }
}