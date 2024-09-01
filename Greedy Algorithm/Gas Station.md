Leetcode Question : [Gas Station](https://leetcode.com/problems/gas-station/)

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, start = 0, tank = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += (gas[i] - cost[i]);

            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
}
```
