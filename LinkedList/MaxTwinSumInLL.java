/*
Leetcode Question :
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
*/
class Solution {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode front;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode returnMiddleNode(ListNode head) {
        ListNode slow = head; // renamed tortoise to slow
        ListNode fast = head; // renamed hare to fast
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return 0; // No pairs to sum if list is empty or has only one node
        }

        // Find the middle of the list
        ListNode mid = returnMiddleNode(head);

        // Reverse the second half of the list
        ListNode head2 = reverse(mid);

        // Initialize pointers for the first and second halves
        ListNode head1 = head;
        int maxSum = Integer.MIN_VALUE;

        // Compare values from the start and the reversed second half
        while (head2 != null) {
            int sum = head1.val + head2.val;
            maxSum = Math.max(maxSum, sum);
            head1 = head1.next;
            head2 = head2.next;
        }

        return maxSum;
    }
}
