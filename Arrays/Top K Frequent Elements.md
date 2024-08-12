### Leetcode Question: [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)

### Java
```java
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.poll().getKey();
            i++;
        }
        return result;
    }
}
```

### C++
```cpp
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

vector<int> topKFrequent(vector<int>& nums, int k) {
    vector<int> result(k);
    unordered_map<int, int> freq;

    // Step 1: Count the frequencies
    for (int num : nums) {
        freq[num]++;
    }
    
    // Step 2: Use a min-heap to keep the top k elements
    auto cmp = [](pair<int, int>& a, pair<int, int>& b) {
        return a.second > b.second;
    };
    priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);
    
    for (auto& entry : freq) {
        pq.push(entry);
        if (pq.size() > k) {
            pq.pop();
        }
    }
    
    // Step 3: Extract the result from the heap
    int i = 0;
    while (!pq.empty()) {
        result[i] = pq.top().first;
        pq.pop();
        i++;
    }
    
    return result;
}
```
