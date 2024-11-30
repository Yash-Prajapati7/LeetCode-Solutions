Leetcode Question : [Reorder List](https://leetcode.com/problems/reorder-list/)

```java
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode next = null;

        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode left = head, slow = head, fast = head, right = null;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        right = reverse(slow.next);
        slow.next = null;

        ListNode leftNext = null;
        ListNode rightNext = null;

        while(left != null && right != null) {
            leftNext = left.next;
            rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }
}
```
