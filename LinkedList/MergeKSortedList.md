Leetcode Question : https://leetcode.com/problems/merge-k-sorted-lists/
## Brute Force
```java
class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify handling the head
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        ListNode head1 = list1;
        ListNode head2 = list2;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining part of head1 or head2
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        // Return the merged list which starts after the dummy node
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}
```
## Optimal approach (Using a Priority Queue)
```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a dummy node to act as the starting point of the merged linked list
        ListNode dummy = new ListNode(0);
        
        // Initialize a priority queue (min-heap) to keep track of the smallest nodes
        // The queue will sort ListNode based on their 'val' field
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each non-null linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        
        // 'current' will point to the current end of the merged linked list
        ListNode current = dummy;
        
        // While the priority queue is not empty, process the smallest node
        while (!pq.isEmpty()) {
            // Extract the node with the smallest value from the priority queue
            ListNode temp = pq.poll();
            
            // Append this node to the merged linked list
            current.next = temp;
            
            // Move the 'current' pointer to the new end of the merged list
            current = current.next;
            
            // If the extracted node has a next node, add it to the priority queue
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        
        // Return the merged linked list, which starts after the dummy node
        return dummy.next;
    }
}

```
