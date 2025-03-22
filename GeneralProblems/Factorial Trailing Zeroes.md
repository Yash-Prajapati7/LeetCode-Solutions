Leetcode Question : [Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)
### Java
```java
class Solution {
    public int trailingZeroes(int n) {
        if(n <= 4) return 0;
        return n/5 + trailingZeroes(n / 5);
    }
}
```

### Explanation:
To count trailing zeros in `n!`, we need to count the number of times `10` appears as a factor. Since `10 = 2 × 5`, we focus on counting the number of `5`s in `n!` because there will always be more `2`s than `5`s.

We do this by:
1. Counting how many numbers up to `n` are divisible by `5` (each contributes at least one `5`).
2. Counting how many numbers are divisible by `25` (since `25 = 5 × 5`, each contributes an extra `5`).
3. Repeating this process for `125, 625`, etc., until `n` becomes `0`.

This approach gives us the total count of `5`s, which determines the number of trailing zeros in `n!`.
