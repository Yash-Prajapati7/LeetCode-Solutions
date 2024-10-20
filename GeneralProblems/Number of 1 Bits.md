Leetcode Question : [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)

```java
class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        while(n > 0) {
            if((n & 1) == 1) {
                ones++;
            }
            n >>= 1;
        }
        return ones;
    }
}
```
