Leetcode Question : [Solving Questions With Brainpower](https://leetcode.com/problems/solving-questions-with-brainpower/)

### Java
```java
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        int index = 0;

        for(int i = n - 1; i >= 0; i--) {
            index = i + questions[i][1] + 1;
            if(index < n) dp[i] = dp[index] + questions[i][0];
            else dp[i] = questions[i][0];

            if(i < n - 1) dp[i] = dp[i] > dp[i + 1] ? dp[i] : dp[i + 1]; 
        }

        return dp[0];
    }
}
```
