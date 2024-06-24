Leetcode Question : https://leetcode.com/problems/binary-tree-maximum-path-sum/
```java
class Solution {
    public static int findMax(TreeNode root, int [] max) {
        if (root == null) {
            return 0;
        }

        // Calculate the maximum path sum for the left and right subtrees
        int leftMaxPath = Math.max(0, findMax(root.left, max));
        int rightMaxPath = Math.max(0, findMax(root.right, max));

        // Update the overall maximum path sum
        max[0] = Math.max(max[0], leftMaxPath + rightMaxPath + root.val);

        // Return the maximum sum considering only one branch (either left or right) along with the current node
        return Math.max(leftMaxPath, rightMaxPath) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int [] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }
}
