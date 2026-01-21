Leetcode Question : [Construct the Minimum Bitwise Array II](https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/)

### Java

```java
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        int current = 0, result = 0, d = 1;

        for (int i = 0; i < n; i++) {
            current = nums.get(i);
            result = -1;
            d = 1;

            while((current & d) != 0) {
                result = current - d;
                d <<= 1;
            }

            ans[i] = result;
        }

        return ans;
    }
}
```

### C++

```cpp
// Leetcode Question : https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        int n = (int)nums.size();
        vector<int> ans(n);
        int current = 0, result = 0, d = 1;

        for (int i = 0; i < n; i++) {
            current = nums[i];
            result = -1;
            d = 1;

            while ((current & d) != 0) {
                result = current - d;
                d <<= 1;
            }

            ans[i] = result;
        }

        return ans;
    }
};
```
