Leetcode Question : [Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/)

### Java

```java
class Solution {
    public int numTilings(int n) {
        if(n <= 2) return n;
        int mod = 1000000007;
        int ptr3 = 1, ptr2 = 1, ptr1 = 2;
        int result = 0;

        for(int i = 3; i <= n; i++) {
            long current = (ptr1 << 1);
            result = ((int)(current % mod) +  ptr3) % mod;
            ptr3 = ptr2;
            ptr2 = ptr1;
            ptr1 = result;
        }

        return result;
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
For a dynamic programming approach [Click Here](https://github.com/Yash-Prajapati7/LeetCode-Solutions/blob/main/Dynamic%20Programming/Domino%20and%20Tromino%20Tiling.md)
