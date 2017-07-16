/*
Find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
--------------------------------------------------------------------------------
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(1)
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
           return 0;
       }
        int maxHerePre = nums[0];
        int minHerePre = nums[0];
        int maxHere = nums[0];
        int minHere = nums[0];
        int maxSofar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
            minHere = Math.min(Math.min(minHerePre * nums[i], maxHerePre * nums[i]), nums[i]);
            maxSofar = Math.max(maxSofar, maxHere);
            maxHerePre = maxHere;
            minHerePre = minHere;
        }
        return maxSofar;
    }
}