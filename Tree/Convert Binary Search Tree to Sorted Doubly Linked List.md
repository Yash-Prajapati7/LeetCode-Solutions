Leetcode Question : [Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/)

```java
class Solution {
    TreeNode prev = null;

    public TreeNode bst2dll(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = bst2dll(root.left);
        if (prev == null) {
            head = root; // Initialize head of the doubly linked list
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bst2dll(root.right);
        return head;
    }
}
```
