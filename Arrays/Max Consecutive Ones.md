Leetcode Question : [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

### Java
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ones = 0, max = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                ones++;
            }
            else {
                max = Math.max(ones, max);
                ones = 0;
            }
        }

        return Math.max(ones, max);
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int n = nums.size();
        int ones = 0, maxCount = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                ones++;
            }
            else {
                maxCount = max(ones, maxCount);
                ones = 0;
            }
        }

        return max(ones, maxCount);
    }
};
```
