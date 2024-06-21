/*
Leetcode Question :
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
*/
public class SwapNodesInLL {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPrev = dummy, secondPrev = dummy;
        ListNode first = head, second = head;

        // Move first k-1 steps forward
        for (int i = 1; i < k; i++) {
            if (first.next == null) return head; // Edge case: k is larger than list length
            firstPrev = first;
            first = first.next;
        }

        // Use two-pointer technique to find the k-th node from the end
        ListNode temp = first;
        while (temp.next != null) {
            secondPrev = second;
            second = second.next;
            temp = temp.next;
        }

        // If the nodes to be swapped are the same, no need to swap
        if (first == second) {
            return head;
        }

        // Swap nodes
        firstPrev.next = second;
        secondPrev.next = first;

        // Swap next pointers
        ListNode tmp = first.next;
        first.next = second.next;
        second.next = tmp;

        return dummy.next;
    }
}
