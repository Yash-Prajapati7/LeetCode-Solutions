Leetcode Question : https://leetcode.com/problems/diameter-of-binary-tree/
## Approach
- To determine the diameter of a binary tree, we need to find the maximum value of the sum of the lengths of the left and right subtrees 
for any given node. The diameter can be understood as the longest path between any two nodes in the tree, 
which may or may not pass through the root.
- To calculate the height of a tree, the formula 1 + max(height of left subtree, height of right subtree) is used.
- For the diameter, while calculating the height, we also keep track of the maximum value of left subtree height + right subtree height
  encountered during the traversal.

```java
class Solution {
    public int findDiameter(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftSide = findDiameter(root.left, max);
        int rightSide = findDiameter(root.right, max);
        max[0] = Math.max(max[0], leftSide + rightSide);
        return 1 + Math.max(leftSide, rightSide);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1]; // Array to hold max value
        findDiameter(root, max);
        return max[0];
    }
}
```
