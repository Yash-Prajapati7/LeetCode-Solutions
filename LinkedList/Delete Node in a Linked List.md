Leetcode Question: [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

```java
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = null;
    }
}
```
