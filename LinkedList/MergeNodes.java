// Leetcode Question : https://leetcode.com/problems/merge-nodes-in-between-zeros
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode temp = head.next;
        int sum = 0;

        while (temp != null) {
            if (temp.val != 0) {
                sum += temp.val;
            } else {
                prev.next = new ListNode(sum);
                prev = prev.next;
                sum = 0; // Reset sum after creating new node
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}
