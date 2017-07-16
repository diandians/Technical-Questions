/*
PROBLEM 162
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its
 index.

The array may contain multiple peaks, in that case return the index to any one 
of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should
 return the index number 2.
 -------------------------------------------------------------------------------
*/

// time O(n)
 public class Solution {
    public int findPeakElement(int[] nums) {
    	// deal with special case (corner case) can save time.
        if (nums.length <= 1) return 0; 


        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;

    }
}