Leetcode Question: [Maximal Score After Applying K Operations](https://leetcode.com/problems/maximal-score-after-applying-k-operations/)

### Java
```java
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-Heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        long ans = 0;
        while (k-- > 0) {
            int maxVal = maxHeap.poll(); // Extract the maximum element
            ans += maxVal;
            maxHeap.offer((maxVal + 2) / 3); // Add the updated value back to the heap
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<int> maxHeap; // Max-Heap
        for (int num : nums) {
            maxHeap.push(num);
        }

        long long ans = 0;
        while (k-- > 0) {
            int maxVal = maxHeap.top(); // Extract the maximum element
            maxHeap.pop();
            ans += maxVal;
            maxHeap.push((maxVal + 2) / 3); // Add the updated value back to the heap
        }

        return ans;
    }
};
```
