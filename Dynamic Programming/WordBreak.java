/*
PROBLEM 139
Given a non-empty string s and a dictionary wordDict containing a list of 
non-empty words, determine if s can be segmented into a space-separated sequence
 of one or more dictionary words. You may assume the dictionary does not contain
  duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set 
of strings). Please reload the code definition to get the latest changes.
*/

public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        List<Integer> index = new ArrayList<>();
        index.add(0);
        
        for (int i = 1; i <= s.length(); i++) {
            int size = index.size();
            for (int j = size - 1; j >= 0; j--) {
                if (dict.contains(s.substring(index.get(j), i))) {
                    index.add(i);
                    break;
                }
            }
        }
        return index.get(index.size() - 1) == s.length();
    }
}