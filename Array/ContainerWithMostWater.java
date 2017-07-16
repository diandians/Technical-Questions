/*
PROBLEM 11
Given n non-negative integers a1, a2, ..., an, where each represents a point at
 coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
 line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
--------------------------------------------------------------------------------
two pointers
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(n)
*/

public class Solution {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
                int volume = (r - l) * Math.min(height[r], height[l]);
                if (volume > max) {
                    max = volume;
                }
                if (height[r] > height[l]) {
                   l++; 
                } else {
                    r--;
                }
        }
        return max;
    }
}