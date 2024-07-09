Leetcode Question : https://leetcode.com/problems/insert-into-a-binary-search-tree/
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return root;
    }
}

```
