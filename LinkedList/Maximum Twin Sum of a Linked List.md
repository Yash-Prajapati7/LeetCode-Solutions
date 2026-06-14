Leetcode Question : [Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list)

### Java

```java
class Solution {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode front;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode returnMiddleNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }

    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        ListNode mid = returnMiddleNode(head);

        ListNode head2 = reverse(mid);

        ListNode head1 = head;
        int maxSum = Integer.MIN_VALUE;

        while (head2 != null) {
            int sum = head1.val + head2.val;
            maxSum = Math.max(maxSum, sum);
            head1 = head1.next;
            head2 = head2.next;
        }

        return maxSum;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static ListNode* reverse(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }

        ListNode* temp = head;
        ListNode* prev = nullptr;
        ListNode* front;

        while (temp != nullptr) {
            front = temp->next;
            temp->next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    static ListNode* returnMiddleNode(ListNode* head) {
        ListNode* tortoise = head;
        ListNode* hare = head;

        while (hare != nullptr && hare->next != nullptr) {
            tortoise = tortoise->next;
            hare = hare->next->next;
        }

        return tortoise;
    }

    int pairSum(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return 0;
        }

        ListNode* mid = returnMiddleNode(head);

        ListNode* head2 = reverse(mid);

        ListNode* head1 = head;
        int maxSum = INT_MIN;

        while (head2 != nullptr) {
            int sum = head1->val + head2->val;
            maxSum = max(maxSum, sum);

            head1 = head1->next;
            head2 = head2->next;
        }

        return maxSum;
    }
};
```
