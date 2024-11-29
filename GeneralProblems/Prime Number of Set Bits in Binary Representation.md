Leetcode Question: [Prime Number of Set Bits in Binary Representation](leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)

```java
class Solution {
    private int setBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int countPrimeSetBits(int left, int right) {
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};

        int count = 0;

        for (int i = left; i <= right; i++) {
            if (primes[setBits(i)] == 1) {
                count++;
            }
        }

        return count;
    }
}
```
