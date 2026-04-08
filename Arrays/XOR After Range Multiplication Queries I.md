Leetcode Question : [XOR After Range Multiplication Queries I](https://leetcode.com/problems/xor-after-range-multiplication-queries-i/)

### Java

```java
class Solution {
    private static final int MOD = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) (((long) nums[i] * v) % MOD);
            }
        }

        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static const int MOD = 1000000007;
    
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        for (auto &q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((1LL * nums[i] * v) % MOD);
            }
        }

        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }
};
```
