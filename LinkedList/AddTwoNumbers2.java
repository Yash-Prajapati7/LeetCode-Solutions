// Leetcode Question : https://leetcode.com/problems/add-two-numbers-ii/
class Solution {
    // method to reverse a linkedlist
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode front;
        while(temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    // method to add two numbers represented as linkedlist
    // prerequisite : https://leetcode.com/problems/add-two-numbers/
    private ListNode addTwoNumber(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            newHead.next = new ListNode(sum % 10);
            newHead = newHead.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse l1 & l2, run the same functon that was in AddTwoNumbers and reverse the final answer and return it.
        return reverse(addTwoNumber(reverse(l1), reverse(l2)));
    }
}
