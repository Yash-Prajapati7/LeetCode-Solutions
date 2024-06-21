/*
Leetcode Question :
https://leetcode.com/problems/swap-nodes-in-pairs/
*/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Consider the example of 1->2->3->4->null
        ListNode dummy = new ListNode(0);
        dummy.next = head;  //Create a dummy node to ease things up... (dummy->1->2->3->4->null)
        ListNode pointer = dummy;

        while(pointer.next != null && pointer.next.next != null) {
            ListNode node1 = pointer.next;
            ListNode node2 = pointer.next.next;

            node1.next = node2.next; //In 1->2->3->4->null, the link 1->2 will become 1->3 (For the 1st iteration)
            node2.next = node1; //The link 2->3 will become 2->1 (For the 1st iteration)

            pointer.next = node2;   //pointer -> 1 will change to pointer -> 2
            pointer = node1;        //move the pointer for next iteration to a node before next node1
                                    // i.e 2->1(pointer)->3->4->null
        }
        return dummy.next;
    }
}
