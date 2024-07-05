// Leetcode Question : https://leetcode.com/problems/add-two-numbers/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        
        while (l1 != null || l2 != null || carry != 0) {
            //add carry of the previous addition directly to the sum
            int sum = carry;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            newHead.next = new ListNode(sum % 10);
            newHead = newHead.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
