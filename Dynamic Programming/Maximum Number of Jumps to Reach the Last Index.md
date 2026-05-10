Leetcode Question : [Maximum Number of Jumps to Reach the Last Index](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/)

### Java

```java
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        
        if (n == 2) {
            int dif = nums[1] - nums[0];
            
            if ((-1 * target) <= dif && dif <= target) {
                return 1;
            } else {
                return -1;
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(Math.abs(nums[j] - nums[i]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] < 0 ? -1 : dp[n - 1];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumJumps(vector<int>& nums, int target) {
        int n = nums.size();

        if (n == 2) {
            int dif = nums[1] - nums[0];

            if ((-1 * target) <= dif && dif <= target) {
                return 1;
            } else {
                return -1;
            }
        }

        vector<int> dp(n, INT_MIN);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (abs(nums[j] - nums[i]) <= target) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] < 0 ? -1 : dp[n - 1];
    }
};
```
