Leetcode Question : [Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)

### Java

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, zeros = 0, ans = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeros++;

            while (zeros > 1) {
                if (nums[start] == 0) zeros--;
                start++;
            }

            ans = ans < (end - start) ? (end - start) : ans;
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
    int longestSubarray(vector<int>& nums) {
        int start = 0, zeros = 0, ans = 0;

        for (int end = 0; end < nums.size(); end++) {
            if (nums[end] == 0) zeros++;

            while (zeros > 1) {
                if (nums[start] == 0) zeros--;
                start++;
            }

            ans = max(ans, end - start);
        }

        return ans;
    }
};
```
