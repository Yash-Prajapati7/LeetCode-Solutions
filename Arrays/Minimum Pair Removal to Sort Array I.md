Leetcode Question : [Minimum Pair Removal to Sort Array I](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/)

### Java

```java
class Solution {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private boolean isSorted(Node head) {
        while (head != null && head.next != null) {
            if (head.next.val < head.val) return false;
            head = head.next;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        Node head = new Node(nums[0]);
        Node temp = head;

        for (int i = 1; i < nums.length; i++) {
            temp.next = new Node(nums[i]);
            temp = temp.next;
        }

        int count = 0;

        while (!isSorted(head)) {
            temp = head;
            Node minNode = head;
            int minSum = Integer.MAX_VALUE;

            while (temp.next != null) {
                int current = temp.val + temp.next.val;
                if (current < minSum) {
                    minSum = current;
                    minNode = temp;
                }
                temp = temp.next;
            }

            // merge minNode and minNode.next
            minNode.val = minSum;
            minNode.next = minNode.next.next;

            count++;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    class Node {
    public:
        int val;
        Node* next;

        Node(int val) {
            this->val = val;
            next = nullptr;
        }
    };

    bool isSorted(Node* head) {
        while (head != nullptr && head->next != nullptr) {
            if (head->next->val < head->val) return false;
            head = head->next;
        }
        return true;
    }

    int minimumPairRemoval(vector<int>& nums) {
        Node* head = new Node(nums[0]);
        Node* temp = head;

        for (int i = 1; i < (int)nums.size(); i++) {
            temp->next = new Node(nums[i]);
            temp = temp->next;
        }

        int count = 0;

        while (!isSorted(head)) {
            temp = head;
            Node* minNode = head;
            int minSum = INT_MAX;

            while (temp->next != nullptr) {
                int current = temp->val + temp->next->val;
                if (current < minSum) {
                    minSum = current;
                    minNode = temp;
                }
                temp = temp->next;
            }

            // merge minNode and minNode->next
            minNode->val = minSum;
            minNode->next = minNode->next->next;

            count++;
        }

        return count;
    }
};
```
