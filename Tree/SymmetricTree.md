Leetcode Question : https://leetcode.com/problems/symmetric-tree/

```java
class Solution {
    public boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == rightNode;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
}

```
