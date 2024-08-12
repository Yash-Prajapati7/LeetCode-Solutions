Leetcode Question: [Neither Minimum nor Maximum](https://leetcode.com/problems/neither-minimum-nor-maximum/)

### Java
```java
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        for(int num : nums) {
            if(num != min && num != max) {
                return num;
            }
        }

        return -1;
    }
}
```

### C++
```cpp
class Solution {
public:
    int findNonMinOrMax(vector<int>& nums) {
        if(nums.size() < 3) {
            return -1;
        }

        int max = INT_MIN;
        int min = INT_MAX;

        for(int num : nums) {
            max = max(num, max);
            min = min(num, min);
        }

        for(int num : nums) {
            if(num != min && num != max) {
                return num;
            }
        }

        return -1;
    }
};
```
