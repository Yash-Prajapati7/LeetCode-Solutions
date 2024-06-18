## Node Class for LinkedList (used in some of the codes)

Below is the Java code for the `Node` class used in a linked list:

```java
class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```
## Defination of the ListNode class for LinkedList which leetcode uses

```java
public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
```
