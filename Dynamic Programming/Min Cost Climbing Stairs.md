Leetcode Question : [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### Java

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + ((dp[i - 1] < dp[i - 2]) ? dp[i - 1] : dp[i - 2]);
        }

        return ((dp[n - 1] < dp[n - 2]) ? dp[n - 1] : dp[n - 2]);
    }
}
```
