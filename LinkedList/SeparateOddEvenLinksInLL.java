public class SeparateOddEvenLinksInLL {
    public static Node separate(Node head) {
        Node odd = head;
        Node evenHead = head.next;
        Node even = head.next;
        while(even.next != null && even != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
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
        int [] nums = {2,3,1,4,5,6};
        head = fromArray(nums);
        print(separate(head));
    }
}
