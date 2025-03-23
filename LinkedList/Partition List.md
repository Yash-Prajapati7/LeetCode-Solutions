Leetcode Question : [Partition List](https://leetcode.com/problems/partition-list/)

```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode lesserHead = lesser;
        ListNode greaterHead = greater;
        ListNode ptr = head, front = null;

        while(ptr != null) {
            front = ptr.next;
            ptr.next = null;
            if(ptr.val < x) {
                lesser.next = ptr;
                lesser = lesser.next;
            }
            else {
                greater.next = ptr;
                greater = greater.next;
            }
            ptr = front;
        }

        lesser.next = greaterHead.next;
        return lesserHead.next;
    }
}
```
