Leetcode Question : [Minimum Difference in Sums After Removal of Elements](https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements)

### Java

```java
class Solution {
    public long minimumDifference(int[] nums) {
        int n3 = nums.length;   // 3n
        int n1 = n3 / 3;        // n
        int n2 = n1 << 1;       // 2n

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long[] part1 = new long[n1 + 1];
        long sum = 0;

        for(int i = 0; i < n1; i++) {
            sum += nums[i];
            maxHeap.offer(nums[i]);
        }

        part1[0] = sum;

        for(int i = n1; i < n2; i++) {
            sum += nums[i];
            maxHeap.offer(nums[i]);
            sum -= maxHeap.poll();
            part1[i - n1 + 1] = sum;
        }

        long sum2 = 0;
        for(int i = n3 - 1; i >= n2; i--) {
            sum2 += nums[i];
            minHeap.offer(nums[i]);
        }

        long ans = part1[n1] - sum2;
        for(int i = n2 - 1; i >= n1; i--) {
            sum2 += nums[i];
            minHeap.offer(nums[i]);
            sum2 -= minHeap.poll();
            ans = (ans < part1[i - n1] - sum2) ? ans : part1[i - n1] - sum2;
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        int n3 = nums.size();   // 3n
        int n1 = n3 / 3;        // n
        int n2 = n1 << 1;       // 2n

        priority_queue<int> maxHeap;
        priority_queue<int, vector<int>, greater<int>> minHeap;

        vector<long long> part1(n1 + 1);
        long long sum = 0;

        for(int i = 0; i < n1; i++) {
            sum += nums[i];
            maxHeap.push(nums[i]);
        }

        part1[0] = sum;

        for(int i = n1; i < n2; i++) {
            sum += nums[i];
            maxHeap.push(nums[i]);
            sum -= maxHeap.top();
            maxHeap.pop();
            part1[i - n1 + 1] = sum;
        }

        long long sum2 = 0;
        for(int i = n3 - 1; i >= n2; i--) {
            sum2 += nums[i];
            minHeap.push(nums[i]);
        }

        long long ans = part1[n1] - sum2;

        for(int i = n2 - 1; i >= n1; i--) {
            sum2 += nums[i];
            minHeap.push(nums[i]);
            sum2 -= minHeap.top();
            minHeap.pop();
            ans = min(ans, part1[i - n1] - sum2);
        }

        return ans;
    }
};
```
