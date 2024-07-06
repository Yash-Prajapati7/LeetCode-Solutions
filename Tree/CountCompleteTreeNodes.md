Leetcode Question : https://leetcode.com/problems/count-complete-tree-nodes/
```java
class Solution {
    private int leftHeight(TreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    private int rightHeight(TreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if(leftHeight == rightHeight) {
            return ((1 << leftHeight) - 1); // this is same as 2^leftHeight - 1
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```
