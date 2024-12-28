Leetcode Question : [Determine if a Cell is Reachable at a Given Time](https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/)

```java
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x = fx - sx;
        x = x < 0 ? -x : x; // Taking absolute value of 'x'
        int y = fy - sy;
        y = y < 0 ? -y : y; // Taking absolute value of 'y'

        if(x + y == 0 && t == 1) return false;       
        return x <= t && y <= t;
    }
}
```
