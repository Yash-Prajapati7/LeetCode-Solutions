/*
Leetcode Question :
https://leetcode.com/problems/palindrome-linked-list/description/
*/
public class PalindromeLLCheck {
    public static Node returnMiddleNode(Node head) {
        Node tortoise = head;
        Node hare = head;
        while(hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }
    public static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;
        Node front;
        while(temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public static boolean checkPalindrome(Node head) {
        Node partition = returnMiddleNode(head);
        Node first = head;
        Node second = reverse(partition.next);
        while(second != null) {
            if(first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    public static Node fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = null;
        int [] nums = {4,21,2,5,6};
        head = fromArray(nums);
        System.out.println(checkPalindrome(head));
    }
}
