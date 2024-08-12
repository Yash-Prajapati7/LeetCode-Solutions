Leetcode Question: [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

### Java
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for(int num : nums) {
            if(pq.size() < k) {
                pq.offer(num);
            }
            else if(num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}
```

### C++
```cpp
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for (int num : nums) {
            pq.push(num);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        return pq.top();
    }
};
```
