Leetcode Question : [Maximum Ascending Subarray Sum](https://leetcode.com/problems/maximum-ascending-subarray-sum/)

### Java
```java
class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int maxSum = 0, currentSum = 0, maxEle = nums[0], j = 0;

        for(int i = 0; i < n; i = j) {
            j = i + 1;
            maxEle = nums[i];
            currentSum = nums[i];
            while(j < n && nums[j] > maxEle) {
                currentSum += nums[j];
                maxEle = nums[j];
                j++;
            }
            maxSum = maxSum < currentSum ? currentSum : maxSum;
        }

        return maxSum;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        int maxSum = 0, currentSum = 0, maxEle = nums[0], j = 0;

        for(int i = 0; i < n; i = j) {
            j = i + 1;
            maxEle = nums[i];
            currentSum = nums[i];
            while(j < n && nums[j] > maxEle) {
                currentSum += nums[j];
                maxEle = nums[j];
                j++;
            }
            maxSum = max(maxSum, currentSum);
        }

        return maxSum;
    }
};
```
