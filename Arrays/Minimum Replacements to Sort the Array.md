Leetcode Question : [Minimum Replacements to Sort the Array](https://leetcode.com/problems/minimum-replacements-to-sort-the-array/)

### Java
```java
class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int prev = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            if(prev >= nums[i]) {
                prev = nums[i];
            }
            else {
                int steps = ((nums[i] + prev - 1) / prev) - 1;  // Taking ceil value of (nums[i] / prev)
                ans += steps;
                prev = nums[i] / (steps + 1);
            }
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
    long long minimumReplacement(vector<int>& nums) {
        int n = nums.size();
        long long ans = 0;
        int prev = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            if(prev >= nums[i]) {
                prev = nums[i];
            }
            else {
                int steps = ((nums[i] + prev - 1) / prev) - 1;  // Taking ceil value of (nums[i] / prev)
                ans += steps;
                prev = nums[i] / (steps + 1);
            }
        }
        return ans;
    }
};
```
