Leetcode Question : [Count Total Number of Colored Cells](https://leetcode.com/problems/count-total-number-of-colored-cells/)

```java
class Solution {
    public long coloredCells(int n) {
        long ans = 1 + (long) n * (n - 1) * 2;
        return ans;
    }
}
```

Basic Observation :<br>
n=1, 1<br>
n=2, 1+4<br>
n=3, 1+4+8<br>
n=4, 1+4+8+12<br>
and so on!
