Leetcode Question: [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

### Java
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            currSum = max(nums[i], currSum + nums[i]);
            sum = max(sum, currSum);
        }
        return sum;
    }
};
```
