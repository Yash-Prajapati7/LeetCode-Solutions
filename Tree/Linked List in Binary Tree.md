Leetcode Question : [Linked List in Binary Tree](https://leetcode.com/problems/linked-list-in-binary-tree/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean maxPath(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        if(root == null || head.val != root.val) {
            return false;
        }
        return maxPath(head.next, root.left) || maxPath(head.next, root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }
        return maxPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
```
