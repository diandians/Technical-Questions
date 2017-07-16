/*
PROBLEM 572
 Given two non-empty binary trees s and t, check whether tree t has exactly the 
 same structure and node values with a subtree of s. A subtree of s is a tree 
 consists of a node in s and all of this node's descendants. The tree s could 
 also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of 
s.
----------------------------------------------------------------------------
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Solution 2-preoder traversal：
    time complexity  O(n)
    space complexity O(n),  n-number of nodes in s */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String ss = generateString(s);
        String tt = generateString(t);
        return ss.contains(tt);
    }

    private String generateString(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stackTree = new Stack();
        stackTree.push(s);
        while(!stackTree.isEmpty()) {
            TreeNode cur = stackTree.pop();
            if (cur == null) {
                sb.append(", #");
            } else {
                sb.append(", " + cur.val);
                stackTree.push(cur.right);
                stackTree.push(cur.left);
            }
        }
        return sb.toString();
    }
}

/* Solution 1-tree traversal, recursion：
    time complexity  O(nm),     n-number of nodes in s
                                m-number of nodes in t
    space complexity  O(1) */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) { 
        // corner case, when s == null(cuz we'll use s's reference in the 
        // following)
        if (s == null) {        
            return false;
        }
        // corner case, when s != null && t == null, return what?
        // e.g. {1,2,3}, {}
        if (t == null) {
            return true;
        }
        if (isSame(s, t)) {
            return true;
        }
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return (isSame(s.left, t.left) && isSame(s.right, t.right));
        }
        return false;
    }
}

