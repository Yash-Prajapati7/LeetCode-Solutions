Leetcode Question : [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
- Note : First check out [Convert a sorted array to BST](https://github.com/Yash-Prajapati7/LeetCode-Solutions/blob/main/Tree/Convert%20Sorted%20Array%20to%20Binary%20Search%20Tree.md)
## Method - 1 (Convert the LinkedList to ArrayList or Arrays)
```java
class Solution {
    private TreeNode helper(ArrayList<Integer> arr, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = helper(arr, left, mid - 1);
        root.right = helper(arr, mid + 1, right);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        return helper(arr, 0, arr.size() - 1);
    }
}
```
Method - 2 (Without converting the LinkedList)
```java
class Solution {
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}
```
