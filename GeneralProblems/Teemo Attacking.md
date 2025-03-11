Leetcode Question : [Teemo Attacking](https://leetcode.com/problems/teemo-attacking/)  

```java
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(duration == 0) return 0;
        
        int total = 0, attackDuration = 0, t = 0;
        int n = timeSeries.length;
        for(int i = 0; i < n; i++) {
            t = timeSeries[i];
            attackDuration = t + duration - 1;
            if(((i + 1) < n) && timeSeries[i + 1] <= attackDuration) total += timeSeries[i + 1] - t;
            else total += duration;
        }

        return total;
    }
}
```
