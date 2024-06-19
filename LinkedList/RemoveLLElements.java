/*
Leetcode Question :
https://leetcode.com/problems/remove-linked-list-elements/
*/
public ListNode removeElements(ListNode head, int val) {
        // Initialize prev to a new node with an arbitrary value
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode temp = head;
        
        // This node will be returned as the new head
        ListNode newHead = prev;

        while (temp != null) {
            if (temp.val == val) {
                // Remove the current node by skipping it
                prev.next = temp.next;
            } else {
                // Move prev to current if current is not deleted
                prev = temp;
            }
            // Move temp to the next node
            temp = temp.next;
        }

        // Return the updated head, which is the next node of the initial new node
        return newHead.next;
    }
