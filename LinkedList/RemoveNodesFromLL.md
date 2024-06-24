Leetcode Question :
https://leetcode.com/problems/remove-nodes-from-linked-list/
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Step 2: Traverse the reversed list and remove nodes
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = reversedHead;
        int maxSoFar = Integer.MIN_VALUE;

        while (temp != null) {
            if (temp.val >= maxSoFar) {
                maxSoFar = temp.val;
                current.next = temp;
                current = current.next;
            }
            temp = temp.next;
        }
        current.next = null; // Terminate the list

        // Step 3: Reverse the list again to restore original order
        return reverseList(dummy.next);
    }       
}
```
