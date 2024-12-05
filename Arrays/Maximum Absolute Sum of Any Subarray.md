Leetcode Question : [Maximum Absolute Sum of Any Subarray](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/)

### Java
```java
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, min = 0, max = 0;
        
        for(int num : nums) {
            sum += num;
            min = sum < min ? sum : min;
            max = sum > max ? sum : max;
        }

        return max - min;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int sum = 0, min = 0, max = 0;
        
        for(int num : nums) {
            sum += num;
            min = sum < min ? sum : min;
            max = sum > max ? sum : max;
        }

        return max - min;
    }
};
```
