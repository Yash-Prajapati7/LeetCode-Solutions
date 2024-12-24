Leetcode Question: [Count Primes](https://leetcode.com/problems/count-primes/)

```java
class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        boolean[] primes = new boolean[n + 1];
        for(int i = 2; i <= n; i++) primes[i] = true;
        for(int i = 2; i * i <= n; i++) {
            if(primes[i]) {
                for(int j = i * i; j <= n; j += i) primes[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) if(primes[i]) count++;
        return count;
    }
}
```
