/*
Leetcode Question :
leetcode.com/problems/reverse-nodes-in-k-group/
*/
public class ReverseKNodes {
    public static ListNode findKthNode (ListNode head, int k) {
        while (k > 1 && head != null) {
            head = head.next;
            k--;
        }
        return head;
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode front;
        while(temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode temp = head;
        // Iterate over the list in groups of k
        while(temp != null) {
            // Find the kth node from the current node
            ListNode kthNode = findKthNode(temp, k);
            // If the kth node is null, it means we've reached the end of the list
            if(kthNode == null) {
                // Link the last group's last node to the remaining nodes
                if(prev != null) {
                    prev.next = temp;
                }
                break;
            }
            // Disconnect the kth group from the rest of the list
            ListNode newNode = kthNode.next;
            kthNode.next = null;
            // Reverse the current group
            reverse(temp);
            // If reversing the first group, update the head pointer
            if(temp == head) {
                head = kthNode;
            }
            // Otherwise, link the previous group to the reversed current group
            else {
                prev.next = kthNode;
            }
            // Move the prev pointer to the last node of the reversed group
            prev = temp;
            // Move the temp pointer to the start of the next group
            temp = newNode;
        }
        // Return the new head of the list
        return head;
    }
}
