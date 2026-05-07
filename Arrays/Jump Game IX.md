Leetcode Question : [Jump Game IX](https://leetcode.com/problems/jump-game-ix)

### Java

```java
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] ans = new int[n];

        prefixMax[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixMax[i] = (prefixMax[i - 1] > nums[i]) ? prefixMax[i - 1] : nums[i];
        }

        int suffixMin = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--) {
            if(prefixMax[i] > suffixMin) {
                ans[i] = ans[i + 1];
            }
            else {
                ans[i] = prefixMax[i];
            }

            suffixMin = (suffixMin > nums[i]) ? nums[i] : suffixMin;
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
    vector<int> maxValue(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefixMax(n);
        vector<int> ans(n);

        prefixMax[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixMax[i] = (prefixMax[i - 1] > nums[i]) ? prefixMax[i - 1] : nums[i];
        }

        int suffixMin = INT_MAX;

        for(int i = n - 1; i >= 0; i--) {
            if(prefixMax[i] > suffixMin) {
                ans[i] = ans[i + 1];
            }
            else {
                ans[i] = prefixMax[i];
            }

            suffixMin = (suffixMin > nums[i]) ? nums[i] : suffixMin;
        }

        return ans;
    }
};
```
