Leetcode Question: [Monotonic Array](https://leetcode.com/problems/monotonic-array/)

### Java
```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length - 1;
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[i+1]) {
                increasing = false;
            }
                
            if(nums[i] < nums[i+1]) {
                decreasing = false;
            }
        }
        return (increasing || decreasing);
    }
}
```

### C++
```cpp
class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int n = nums.size() - 1;
        bool increasing = true;
        bool decreasing = true;
        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[i+1]) {
                increasing = false;
            }
                
            if(nums[i] < nums[i+1]) {
                decreasing = false;
            }
        }
        return (increasing || decreasing);
    }
};
```
