Leetcode Question : [Elimination Game](https://leetcode.com/problems/elimination-game/)

```java
class Solution {
    public int lastRemaining(int n) {
        boolean onLeft = true;
        int rem = n;
        int step = 1, head = 1;

        while (rem > 1) {
            head = (onLeft || rem % 2 == 1) ? head + step : head;
            rem >>= 1;
            step <<= 1;
            onLeft = !onLeft;
        }

        return head;
    }
}
```
