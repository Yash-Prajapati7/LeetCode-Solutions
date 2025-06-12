Leetcode Question : [Maximum Difference Between Adjacent Elements in a Circular Array](https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/)

### Java

```java
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = Math.abs(nums[n - 1] - nums[0]);
        int ans = diff;

        for(int i = 1; i < n; i++) {
            diff = Math.abs(nums[i] - nums[i - 1]);
            ans = ans < diff ? diff : ans;
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
    int maxAdjacentDistance(vector<int>& nums) {
        int n = nums.size();
        int diff = abs(nums[n - 1] - nums[0]);
        int ans = diff;

        for(int i = 1; i < n; i++) {
            diff = abs(nums[i] - nums[i - 1]);
            ans = ans < diff ? diff : ans;
        }

        return ans;
    }
};
```
