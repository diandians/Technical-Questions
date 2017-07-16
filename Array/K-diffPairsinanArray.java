/*
PROBLEM 532
Given an array of integers and an integer k, you need to find the number of 
unique k-diff pairs in the array. Here a k-diff pair is defined as an integer 
pair (i, j), where i and j are both numbers in the array and their absolute 
difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique
 pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) 
and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
--------------------------------------------------------------------------------
*/


// Two pointer approach 1: time O(nlogn) space O(1)

public class Solution {
    public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);

            int start = 0, end = 1, result = 0;
            while (start < nums.length && end < nums.length) {
                if (start == end || nums[start] + k > nums[end]) {
                    end++;
                } else if (nums[start] + k < nums[end]) {
                    start++;
                } else {
                    start++;
                    result++;
                    // start
                    //  |
                    // [1, 1, ...., 8, 8]
                    //              |
                    //             end
                    while (start < nums.length && nums[start] == nums[start - 1]) start++;
                    end = Math.max(end + 1, start + 1);
                }
            }
            return result;
    }
}

// Two pointer approach2: time O(nlogn) space O(1)
/*
The code runs in O(n log n) time but occupies O(1) space. It is an in-place 
solution. In fact, though the solution has an O(n log n) runtime, it still 
performs well compared to many linear-time solutions using HashMap since:

- insert/delete/lookup takes O(1) time only in an average case.
- the constant in O(1) is large.
- the overhead becomes much worse when a HashMap occupies more space, and this
  is exactly the case in LeetCode.
*/
public int findPairs(int[] nums, int k) {
    int ans = 0;
    Arrays.sort(nums);
    for (int i = 0, j = 0; i < nums.length; i++) {
        for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) ;
        if (j < nums.length && (long) nums[j] - nums[i] == k) ans++;
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
    }
    return ans;
}