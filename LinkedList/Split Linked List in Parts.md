Leetcode Question : [Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts/)

```java
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Count the total number of nodes in the list
        int totalLength = 0;
        ListNode current = head;
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        // Step 2: Determine the size of each part
        int partSize = totalLength / k;  // Minimum size of each part
        int extraNodes = totalLength % k; // Parts that need an extra node

        // Step 3: Split the list
        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode prev = null;

            // Determine the size of the current part
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);

            // Move through the current part
            for (int j = 0; j < currentPartSize; j++) {
                prev = current;
                current = current.next;
            }

            // If there is a previous node, terminate the current part
            if (prev != null) {
                prev.next = null;
            }

            // Add the current part to the result
            result[i] = partHead;
        }

        return result;
    }
}
```
