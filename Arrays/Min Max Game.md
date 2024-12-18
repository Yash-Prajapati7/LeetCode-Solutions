Leetcode Question : [Min Max Game](https://leetcode.com/problems/min-max-game/)

### Java
```java
class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        while(n > 1) {
            n >>= 1;
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    nums[i] = (nums[(i << 1)] > nums[(i << 1) + 1]) ? nums[(i << 1) + 1] : nums[(i << 1)];
                }
                else {
                    nums[i] = nums[(i << 1)] < nums[(i << 1) + 1] ? nums[(i << 1) + 1] : nums[(i << 1)];
                }
            }
        }

        return nums[0];
    }
}
```

### C++
```cpp
class Solution {
public:
    int minMaxGame(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];

        while(n > 1) {
            n >>= 1;
            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    nums[i] = (nums[(i << 1)] > nums[(i << 1) + 1]) ? nums[(i << 1) + 1] : nums[(i << 1)];
                }
                else {
                    nums[i] = nums[(i << 1)] < nums[(i << 1) + 1] ? nums[(i << 1) + 1] : nums[(i << 1)];
                }
            }
        }

        return nums[0];
    }
};
```
