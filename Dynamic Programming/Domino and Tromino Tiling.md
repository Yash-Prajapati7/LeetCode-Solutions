Leetcode Question : [Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/)

### Java

```java
class Solution {
    public int numTilings(int n) {
        if (n <= 2) return n;

        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty board
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3]) % mod;
        }

        return dp[n];
    }
}
```

### Recurrence Relation:

The number of ways to tile a 2 x N board can be expressed using the recurrence:

```
A[N] = 2 * A[N-1] + A[N-3]
```

This is derived from the pattern:

```
A[3] = 5   = 2 * 2 + 1
A[4] = 11  = 2 * 5 + 1
A[5] = 24  = 2 * 11 + 2
A[6] = 53  = 2 * 24 + 5
A[7] = 117 = 2 * 53 + 11
```
For the space optimised approach [Click Here](https://github.com/Yash-Prajapati7/LeetCode-Solutions/blob/main/GeneralProblems/Domino%20and%20Tromino%20Tiling.md)
