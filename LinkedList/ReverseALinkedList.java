//I am using a converter method to convert array into LinkedList so that it becomes easy for me to create a linked list 
//and everytime I dont have to write a insertAtTail method and do the extra work of adding elements to the list.
public class ReverseALinkedList {
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

        int [] numbers = {1,2,3,4,5};
        head = fromArray(numbers);

        print(head);
        print(reverse(head));
    }
}
