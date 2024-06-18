/*
Leetcode Question : 
https://leetcode.com/problems/intersection-of-two-linked-lists/
*/
public class FindTheIntersectionInLL {
   public class FindTheIntersectionInLL {
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;

        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next;
            d2 = d2 == null? headA:d2.next;
        }

        return d1;
    }
}
