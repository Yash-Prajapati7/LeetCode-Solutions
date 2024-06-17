/*
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
 */
public class DeletionInLinkedList {
    public static int length(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node insertAtTail(int data, Node head) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public static Node deleteHead(Node head) {
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head) {
        Node temp = head;
        Node prev = null;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;

        return head;
    }

    public static Node deleteElement(int data, Node head) {
        Node temp = head;
        int counter = 0;
        Node prev = null;
        while (temp.data != data) {
            counter++;
            prev = temp;
            temp = temp.next;
        }
        if(counter == 0) {
            return deleteHead(head);
        }
        else if(counter == length(head)) {
            return deleteTail(head);
        }
        else {
            prev.next = temp.next;
            temp.next = null;
        }

        return head;
    }
    public static void main(String[] args) {
        Node head = null;
        head = insertAtTail(1,head);
        head = insertAtTail(2,head);
        head = insertAtTail(3,head);
        head = insertAtTail(4,head);
        head = insertAtTail(5,head);

        print(head);
        print(deleteElement(3,head));
    }
}
