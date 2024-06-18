//This algorithm returns the midpoint of the linked list
public class TortoiseAndHare {
    public static int returnMiddleNode(Node head) {
        Node tortoise = head;
        Node hare = head;
        while(hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise.data;
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
        Node head = null;
        int [] nums = {2,3,1,4,5,6,1};
        head = fromArray(nums);
        System.out.println(returnMiddleNode(head));
    }
}
