Leetcode Question : [Insert Greatest Common Divisors in Linked List](https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/)

```java
class Solution {
    private int gcd(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode node1 = head, node2 = head.next;
        while(node2 != null) {
            int gcd = gcd(node1.val, node2.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next = node2;
            node1.next = newNode;
            node1 = node1.next.next;
            node2 = node2.next;
        }
        return head;
    }
}
```
