Leetcode Question : [Longest Subarray With Maximum Bitwise AND](https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/)

### Java
```java
class Solution {
    public int longestSubarray(int[] nums) {
        int size = 0, res = 0, currentMax = -1;
        for(int n : nums) {
            if(n > currentMax) {
                currentMax = n;
                size = 1;
                res = 0;
            }
            else if(n == currentMax) {
                size++;
            }
            else {
                size = 0;
            }
            res = Math.max(res, size);
        }
        return res;
    }
}
```

### C++
```cpp
class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int size = 0, res = 0, currentMax = -1;
        for(int n : nums) {
            if(n > currentMax) {
                currentMax = n;
                size = 1;
                res = 0;
            }
            else if(n == currentMax) {
                size++;
            }
            else {
                size = 0;
            }
            res = max(res, size);
        }
        return res;
    }
};
```
