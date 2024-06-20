/*
Leetcode Question :
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // Initialize two pointers both at the head
        ListNode first = head;
        ListNode second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            // If n is greater than the length of the list, return the head
            if (first == null) {
                return head;
            }
            first = first.next;
        }

        // If first is null after moving n steps, the head needs to be removed
        if (first == null) {
            return head.next;
        }

        // Move both pointers until first reaches the end.
        // Due to this the second pointer will be pointing at the nth node from last.
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // second.next is the node to be deleted
        second.next = second.next.next;

        return head;
    }
}
