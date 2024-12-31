Leetcode Question : [Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)

```java
class Solution {
    private int min(int num1, int num2, int num3) {
        return num1 < num2 ? (num1 < num3 ? num1 : num3) : ((num2 < num3) ? num2 : num3);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        int i = 0;

        for (int day = 1; day <= lastDay; day++) {
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                i++;
                int oneDay = dp[day - 1] + costs[0];
                int sevenDay = dp[0 > day - 7 ? 0 : day - 7] + costs[1];
                int thirtyDay = dp[0 > day - 30 ? 0 : day - 30] + costs[2];
                dp[day] = min(oneDay, sevenDay, thirtyDay);
            }
        }

        return dp[lastDay];
    }
}
```
