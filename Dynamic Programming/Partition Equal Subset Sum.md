Leetcode Question : [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)

### Java
```java
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        if(total % 2 != 0) return false;

        int target = total >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums) {
            for(int currSum = target; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if(dp[target]) return true;
            }
        }

        return dp[target];
    }
}
```
