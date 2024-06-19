/*
Leetcode Question :
https://leetcode.com/problems/sort-list/
*/
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

    public static ListNode returnMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // Find the mid and split the list into two halves
        ListNode mid = returnMid(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // Important to split the list

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHalf);

        return mergeTwoLists(left, right);
    }
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
