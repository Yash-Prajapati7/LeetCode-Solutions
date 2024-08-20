Leetcode Question: [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

### Java
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.add(y - x);
            }
        }

        // Return 0 if the queue is empty, meaning all stones are destroyed
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
```

### C++
```cpp
class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        if (stones.size() == 1) {
            return stones[0];
        }
        
        priority_queue<int> pq(stones.begin(), stones.end());

        while (pq.size() > 1) {
            int y = pq.top();
            pq.pop();
            int x = pq.top();
            pq.pop();

            if (x != y) {
                pq.push(y - x);
            }
        }

        // Return 0 if the queue is empty, meaning all stones are destroyed
        return pq.empty() ? 0 : pq.top();
    }
};
```
