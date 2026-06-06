Leetcode Question : [Left and Right Sum Differences](https://leetcode.com/problems/left-and-right-sum-differences/)

### Java

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 0;
        int leftSum = 0;

        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        for(int i = 0; i < n; i++) {
            total -= nums[i];
            ans[i] = Math.abs(leftSum - total);
            leftSum += nums[i];
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
    vector<int> leftRightDifference(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        int total = 0;
        int leftSum = 0;

        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        for(int i = 0; i < n; i++) {
            total -= nums[i];
            ans[i] = abs(leftSum - total);
            leftSum += nums[i];
        }

        return ans;
    }
};
```
