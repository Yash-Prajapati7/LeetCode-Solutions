Leetcode Question : [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        if(root != null) {
            invertTree(root.left);
            invertTree(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
```
