LeetCode Question : [Divide an Array Into Subarrays With Minimum Cost I](https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/)

### Java

```java
class Solution {
    public int minimumCost(int[] nums) {
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min2) {
                min3 = min2;
                min2 = nums[i];
            } else if (nums[i] < min3) {
                min3 = nums[i];
            }
        }

        return min1 + min2 + min3;
    }
}
```

### C++

```cpp
class Solution {
public:
    int minimumCost(vector<int>& nums) {
        int min1 = nums[0];
        int min2 = INT_MAX;
        int min3 = INT_MAX;

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < min2) {
                min3 = min2;
                min2 = nums[i];
            } else if (nums[i] < min3) {
                min3 = nums[i];
            }
        }

        return min1 + min2 + min3;
    }
};
```
