Leetcode Question : [Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)

### Java

```java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ans = 1, current = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                current++;
                ans = ans < current ? current : ans;
            }
            else current = 1;
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int n = nums.size();
        int ans = 1, current = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                current++;
                ans = ans < current ? current : ans;
            } else {
                current = 1;
            }
        }

        return ans;
    }
};
```
