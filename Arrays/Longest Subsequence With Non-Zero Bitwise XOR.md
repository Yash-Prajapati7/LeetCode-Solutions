Leetcode Question : [Longest Subsequence With Non-Zero Bitwise XOR](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/)

### Java

```java
class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allZero = true;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                allZero = false;
            }

            xor ^= nums[i];
        }

        if (xor > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n = nums.size();
        bool allZero = true;
        int xr = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                allZero = false;
            }

            xr ^= nums[i];
        }

        if (xr > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
};
```
