Leetcode Question: [Smallest Range Covering Elements from K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)

### Java
```java
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // pq to store element, listNumber and its index in list
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE, rStart = 0, rEnd = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[] {val, i, 0});
            max = Math.max(max, val);
        }

        while (pq.size() == nums.size()) {
            int[] data = pq.poll();
            int min = data[0], row = data[1], col = data[2];

            if (max - min < rEnd - rStart) {
                rStart = min;
                rEnd = max;
            }

            if (col + 1 < nums.get(row).size()) {
                int val = nums.get(row).get(col + 1);
                pq.offer(new int[] {val, row, col + 1});
                max = Math.max(max, val);
            }
        }

        return new int[] {rStart, rEnd};
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        // pq to store element, listNumber and its index in list
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        int maxVal = INT_MIN, rStart = 0, rEnd = INT_MAX;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums[i][0];
            pq.push({val, i, 0});
            maxVal = max(maxVal, val);
        }

        while (pq.size() == nums.size()) {
            auto data = pq.top();
            pq.pop();
            int minVal = data[0], row = data[1], col = data[2];

            if (maxVal - minVal < rEnd - rStart) {
                rStart = minVal;
                rEnd = maxVal;
            }

            if (col + 1 < nums[row].size()) {
                int val = nums[row][col + 1];
                pq.push({val, row, col + 1});
                maxVal = max(maxVal, val);
            }
        }

        return {rStart, rEnd};
    }
};
```
