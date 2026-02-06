Leetcode Question : [Minimum Removals to Balance Array](https://leetcode.com/problems/minimum-removals-to-balance-array/)

### Java

```java
class Solution {

    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int ans = n;
        int right = 0;
        int windowSize = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            windowSize = n - (right - left);
            ans = windowSize < ans ? windowSize : ans;
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
    int minRemoval(vector<int>& nums, int k) {
        int n = nums.size();
        if(n == 1) {
            return 0;
        }
        sort(nums.begin(), nums.end());

        int ans = n;
        int right = 0;
        int windowSize = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long long) nums[left] * k) {
                right++;
            }
            windowSize = n - (right - left);
            ans = windowSize < ans ? windowSize : ans;
        }

        return ans;
    }
};
```
