Leetcode Question : https://leetcode.com/problems/running-sum-of-1d-array/description/
### Java
```java
class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
```
### C++
```cpp
#include <vector>

class Solution {
public:
    std::vector<int> runningSum(std::vector<int>& nums) {
        for (int i = 1; i < nums.size(); i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
};

```
