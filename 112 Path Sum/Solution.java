/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
public class Solution {
    public boolean hasPathSum (TreeNode root, int sum) {
        boolean result = DFS(root, sum, 0);

        return result;
    }

    //use DFS to retrive all the nodes of the tree to get the result
    private boolean DFS (TreeNode root, int sum, int pathSum) {
    	if (root != null) {
    		int curSum = pathSum + root.val;
    		if (root.left == null && root.right == null) {
    			if (curSum == sum) {
    				return true;
    			}
    		}
    		else {
    			if (root.left != null) {
    				if (DFS(root.left, sum, curSum)) return true;
    			}
    			if (root.right != null) {
    				if (DFS(root.right, sum, curSum)) return true;
    			}
    		}
    	}

    	return false;
    }
}