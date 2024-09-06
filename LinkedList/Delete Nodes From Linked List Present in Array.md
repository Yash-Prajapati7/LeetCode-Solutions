Leetcode Question : [Delete Nodes From Linked List Present in Array](https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/)

```java
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) {
            hs.add(num);
        }

        ListNode prev = head, current = head.next;

        while(head != null && hs.contains(head.val)) {
            head = head.next;
        }

        if(head == null) {
            return prev;
        }

        prev = head; 
        current = head.next;
        while(current != null) {
            if(hs.contains(current.val)) {
                prev.next = current.next;
            }
            else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
```
