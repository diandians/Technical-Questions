/*
PROBLEM 18
Given an array S of n integers, are there elements a, b, c, and d in S such 
that a + b + c + d = target? Find all unique quadruplets in the array which 
gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
--------------------------------------------------------------------------------
TIME COMPLEXITY: O(n^3)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        Arrays.sort(nums);

        for (int i = 0; i + 3 < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j + 2 < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int l = j + 1, r = nums.length - 1;
                int tar = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] > tar) {
                        r--;
                    } else if (nums[l] + nums[r] < tar){
                        l++;
                    } else {
                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        list.add(new ArrayList(temp));
                        do {
                            r--;
                        } while (r + 1 < nums.length && l < r && nums[r] == nums[r + 1]);
                        do {
                            l++;
                        } while (l < r && nums[l] == nums[l - 1]);
                            
                        
                    }
                }
            }
        }
        
        return list;
    }
}