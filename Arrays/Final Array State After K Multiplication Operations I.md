Leetcode Question : [Final Array State After K Multiplication Operations I](https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/)

### Java
```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] minElement = pq.poll();
            minElement[0] *= multiplier;
            pq.offer(minElement);
        }
        while (!pq.isEmpty()) {
            int[] element = pq.poll();
            nums[element[1]] = element[0];
        }
        return nums;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
        int n = nums.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        for (int i = 0; i < n; i++) {
            pq.push({nums[i], i});
        }
        while (k-- > 0) {
            auto minElement = pq.top();
            pq.pop();
            minElement.first *= multiplier;
            pq.push(minElement);
        }
        while (!pq.empty()) {
            auto element = pq.top();
            pq.pop();
            nums[element.second] = element.first;
        }
        return nums;
    }
};
```
