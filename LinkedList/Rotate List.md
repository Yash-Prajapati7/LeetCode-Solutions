Leetcode Question : [Rotate List](https://leetcode.com/problems/rotate-list/)

```java
class Solution {
    private int length (ListNode head) {
        ListNode temp = head;
        int l = 0;
        while(temp != null) {
            l++;
            temp = temp.next;
        }
        return l;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int n = length(head);
        k = k % n;
        if(k == 0) {
            return head;
        }
        ListNode newHead = null;
        int pos = n - k - 1;
        ListNode temp = head;
        while(pos-- > 0) {
            temp = temp.next;
        }
        newHead = temp.next;
        temp.next = null;
        ListNode curr = newHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }
}
```
