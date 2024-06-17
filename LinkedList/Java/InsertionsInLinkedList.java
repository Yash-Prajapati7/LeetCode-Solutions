class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionInLinkedList {
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

    public static Node insertAtPosition(int data, Node head, int index) {
        if (index < 0) {
            System.out.println("Invalid Index");
            return head;
        }
        if (index == 0) {
            return insertAtHead(data, head);
        }

        Node newNode = new Node(data);
        Node temp = head;
        int counter = 0;

        while (temp != null && counter < index - 1) {
            temp = temp.next;
            counter++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static Node insertAtHead(int data, Node head) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
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

    public static Node insertBeforeData(int data, Node head, int target) {
        if (head == null) return null;
        if (head.data == target) return insertAtHead(data, head);

        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Target not found");
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static Node insertAfterData(int data, Node head, int target) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Target not found");
            return head;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
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

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        Node head = fromArray(nums);
        print(head);  // 1->2->3->null

        head = insertAtPosition(4, head, 1);
        print(head);  // 1->4->2->3->null

        head = insertBeforeData(5, head, 4);
        print(head);  // 1->5->4->2->3->null

        head = insertAfterData(6, head, 2);
        print(head);  // 1->5->4->2->6->3->null

        head = insertAtHead(0, head);
        print(head);  // 0->1->5->4->2->6->3->null

        head = insertAtTail(7, head);
        print(head);  // 0->1->5->4->2->6->3->7->null
    }
}
