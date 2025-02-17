Leetcode Question : [Minimum Operations to Halve Array Sum](https://leetcode.com/problems/minimum-operations-to-halve-array-sum/)  

### Java
```java
class Solution {
    public int halveArray(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        double initialSum = 0, halfSum = 0;
        for(int num : nums) {
            pq.offer((double)num);
            initialSum += num;
        }

        halfSum = initialSum / 2;

        int operations = 0;
        double reducedSum = 0, halvedValue = 0;

        while(!pq.isEmpty() && reducedSum < halfSum) {
            halvedValue = pq.poll() / 2;
            reducedSum += halvedValue;
            pq.offer(halvedValue);
            operations++;
        }

        return operations;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int halveArray(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) {
            return 1;
        }

        priority_queue<double> pq; 
        double initialSum = 0, halfSum = 0;
        for(int num : nums) {
            pq.push((double)num);
            initialSum += num;
        }

        halfSum = initialSum / 2;

        int operations = 0;
        double reducedSum = 0, halvedValue = 0;

        while(!pq.empty() && reducedSum < halfSum) {
            halvedValue = pq.top() / 2;
            pq.pop();
            reducedSum += halvedValue;
            pq.push(halvedValue);
            operations++;
        }

        return operations;
    }
};
```
