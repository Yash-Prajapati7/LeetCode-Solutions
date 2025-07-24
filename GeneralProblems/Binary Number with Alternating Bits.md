Leetcode Question : [Binary Number with Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits)

### Java

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n < 3) return true;
        int prev = n & 1;
        while(n > 0) {
            n >>= 1;
            if((n & 1) == prev) return false;
            prev = n & 1;
        }
        return true;
    }
}
```
