Leetcode Question : https://leetcode.com/problems/recover-binary-search-tree/description/
```java
class Solution {
    private TreeNode first = null;
    private TreeNode middle = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        
        if (first != null && second != null) {
            swap(first, second);
        } else if (first != null && middle != null) {
            swap(first, middle);
        }
    }
}

```
