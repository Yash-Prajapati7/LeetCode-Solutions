/*
Leetcode Question :
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
*/
class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode current = head;

        while (current != null) {
            result = (result << 1) | current.val;
            current = current.next;
        }

        return result;
    }
}