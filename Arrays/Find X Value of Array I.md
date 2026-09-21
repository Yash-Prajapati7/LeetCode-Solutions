### Leetcode Question : [Find X Value of Array I](https://leetcode.com/problems/find-x-value-of-array-i/)

### Java

```java
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int i = 0; i < n; i++) {
            long[] newDP = new long[k];
            newDP[nums[i] % k]++;

            for (long remainder = 0; remainder < k; remainder++) {
                newDP[(int) ((remainder * nums[i]) % k)] += dp[(int) remainder];
            }

            dp = newDP;

            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    vector<long long> resultArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<long long> result(k);
        vector<long long> dp(k);

        for (int i = 0; i < n; i++) {
            vector<long long> newDP(k);
            newDP[nums[i] % k]++;

            for (long long remainder = 0; remainder < k; remainder++) {
                newDP[(remainder * nums[i]) % k] += dp[remainder];
            }

            dp = newDP;

            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
};
```
