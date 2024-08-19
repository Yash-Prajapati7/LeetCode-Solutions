Leetcode Question : [Smallest Value After Replacing With Sum of Prime Factors](https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/)

```java
class Solution {
    private int sumOfPrimes(int n) {
        if (n == 1) {
            return n;
        }
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }

        for (int factor = 3; factor * factor <= n; factor += 2) {
            while (n % factor == 0) {
                sum += factor;
                n /= factor;
            }
        }

        // If n is prime number like 37 it will remain unchanged even after the loops
        if(n > 1) {
            sum += n;
        }

        return sum;
    }

    public int smallestValue(int n) {
        while(true) {
            int newNum = sumOfPrimes(n);
            if(newNum == n) {
                return n;
            }
            n = newNum;
        }
    }
}
```
