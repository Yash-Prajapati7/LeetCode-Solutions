Leetcode Question : [Counting Bits](https://leetcode.com/problems/counting-bits/)

```java
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
```

### Explanation:
To find the number of `1`s in the binary representation of numbers from `0` to `n`, we can observe the following pattern:
1. **If `i` is even:**  
   The number of `1`s in `i` is the same as the number of `1`s in `i / 2` (right-shifting an even number halves it without adding a new `1`).

2. **If `i` is odd:**  
   The number of `1`s in `i` is the number of `1`s in `(i - 1)` plus one additional `1` (as adding `1` to an even number makes it odd).
