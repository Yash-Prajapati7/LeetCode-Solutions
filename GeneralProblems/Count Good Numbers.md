Leetcode Question : [Count Good Numbers](https://leetcode.com/problems/count-good-numbers/)

### Java
```java
class Solution {
    long mod = 1000000007;
    
    private long pow(long x, long n) {
        long result = 1;
        while(n > 0) {
            if((n & 1) == 1) result = (result * x) % mod;
            x = (x * x) % mod;
            n >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        return (int) ((pow(5, (n + 1) >> 1) * pow(4, n >> 1)) % mod);
    }
}
```
