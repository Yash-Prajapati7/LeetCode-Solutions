Leetcode Question : [Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/)
- Reference : [Reservoir Sampling](https://www.geeksforgeeks.org/dsa/reservoir-sampling/)
### Java

```java
class Solution {
    int length = 0;
    ListNode head = null;
    Random r = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int result = head.val;
        int count = 0;
        ListNode node = head;

        while(node != null) {
            count++;
            if(r.nextInt(count) == 0) {
                result = node.val;
            }
            node = node.next;
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
    ListNode* head;
public:
    Solution(ListNode* head) {
        this->head = head;
        srand(time(0));
    }
    
    int getRandom() {
        int result = head->val;
        int count = 0;
        ListNode* node = head;

        while(node != nullptr) {
            count++;
            if(rand() % count == 0) {
                result = node->val;
            }
            node = node->next;
        }

        return result;
    }
};
```
