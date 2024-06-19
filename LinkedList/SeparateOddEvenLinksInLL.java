/*
Leetcode Question :
https://leetcode.com/problems/odd-even-linked-list/
*/
public class SeparateOddEvenLinksInLL {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return early if the list is empty or has only one node.
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // Connect the end of the odd list to the head of the even list
        if (odd != null) {
            odd.next = evenHead;
        }

        return head;
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
        int [] nums = {2,3,1,4,5,6};
        head = fromArray(nums);
        print(oddEvenList(head));
    }
}
