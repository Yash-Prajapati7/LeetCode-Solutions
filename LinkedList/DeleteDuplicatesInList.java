/*
Leetcode Question :
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null; // Handle the case where the list is empty
        
        ListNode temp = head;
        
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                // Skip the next node because it's a duplicate
                temp.next = temp.next.next;
            } else {
                // Move to the next node only if there was no duplicate
                temp = temp.next;
            }
        }
        return head;
    }
}
