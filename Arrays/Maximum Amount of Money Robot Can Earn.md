Leetcode Question : [Maximum Amount of Money Robot Can Earn](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/)

### Java

```java
class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins[0].length;

        // dp[j][k]
        // j -> current column
        // k -> number of neutralizations used
        // k = 0 -> no neutralization used
        // k = 1 -> at most 1 neutralization used
        // k = 2 -> at most 2 neutralizations used
        int[][] dp = new int[n + 1][3];

        // Initialize all states
        for (int j = 0; j <= n; j++) {
            dp[j][0] = Integer.MIN_VALUE >> 1;
            dp[j][1] = Integer.MIN_VALUE >> 1;
            dp[j][2] = Integer.MIN_VALUE >> 1;
        }

        // Starting point before processing any cell
        // We start from dp[1] because columns are being treated as 1-indexed
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 0;

        for (int[] row : coins) {
            for (int j = 1; j <= n; j++) {
                int x = row[j - 1];

                // dp[j][2] -> maximum sum using at most 2 neutralizations
                dp[j][2] = Math.max(
                    // Case 1:
                    // Do not neutralize current cell
                    // Either come from left or top and add current value
                    Math.max(dp[j - 1][2] + x, dp[j][2] + x),

                    // Case 2:
                    // Neutralize current cell
                    // So current cell contributes 0
                    // Previous state must have used at most 1 neutralization
                    Math.max(dp[j - 1][1], dp[j][1])
                );

                // dp[j][1] -> maximum sum using at most 1 neutralization
                dp[j][1] = Math.max(
                    // Case 1:
                    // Do not neutralize current cell
                    Math.max(dp[j - 1][1] + x, dp[j][1] + x),

                    // Case 2:
                    // Neutralize current cell
                    // Previous state must have used 0 neutralizations
                    Math.max(dp[j - 1][0], dp[j][0])
                );

                // dp[j][0] -> no neutralization
                // Simply take maximum of left/top and add current value
                dp[j][0] = Math.max(dp[j - 1][0], dp[j][0]) + x;
            }
        }

        // Last column with at most 2 neutralizations used
        return dp[n][2];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumAmount(vector<vector<int>>& coins) {
        int n = coins[0].size();

        // dp[j][k]
        // j -> current column
        // k -> number of neutralizations used
        vector<vector<int>> dp(n + 1, vector<int>(3));

        // Initialize all states
        for (int j = 0; j <= n; j++) {
            dp[j][0] = INT_MIN >> 1;
            dp[j][1] = INT_MIN >> 1;
            dp[j][2] = INT_MIN >> 1;
        }

        // Starting point
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 0;

        for (auto& row : coins) {
            for (int j = 1; j <= n; j++) {
                int x = row[j - 1];

                dp[j][2] = max(
                    max(dp[j - 1][2] + x, dp[j][2] + x),
                    max(dp[j - 1][1], dp[j][1])
                );

                dp[j][1] = max(
                    max(dp[j - 1][1] + x, dp[j][1] + x),
                    max(dp[j - 1][0], dp[j][0])
                );

                dp[j][0] = max(dp[j - 1][0], dp[j][0]) + x;
            }
        }

        return dp[n][2];
    }
};
```
