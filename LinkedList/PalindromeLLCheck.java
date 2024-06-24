/*
Leetcode Question :
https://leetcode.com/problems/palindrome-linked-list/description/
*/
public class PalindromeLLCheck {
    public static ListNode returnMiddleNode(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
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

    public static boolean isPalindrome(ListNode head) {
        ListNode partition = returnMiddleNode(head);
        ListNode first = head;
        ListNode second = reverse(partition.next);
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = null;
        int[] nums = {4, 21, 2, 5, 6};
        head = fromArray(nums);
        System.out.println(checkPalindrome(head));
    }
}
