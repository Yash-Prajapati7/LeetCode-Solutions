Leetcode Question : [Prime Arrangements](https://leetcode.com/problems/prime-arrangements)

### Java

```java
class Solution {
    public int numPrimeArrangements(int n) {
        long mod = 1_000_000_007;
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
        int primeCount = 0;
        for (int p : primes) {
            if (p > n) break;
            primeCount++;
        }

        long result = (factorial(primeCount, mod) * factorial(n - primeCount, mod)) % mod;
        return (int) result;
    }

    private long factorial(int k, long mod) {
        long res = 1;
        for (int i = 2; i <= k; i++) {
            res = (res * i) % mod;
        }
        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numPrimeArrangements(int n) {
        long long mod = 1000000007;
        vector<int> primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
        int primeCount = 0;
        for (int p : primes) {
            if (p > n) break;
            primeCount++;
        }
        
        long long result = (factorial(primeCount, mod) * factorial(n - primeCount, mod)) % mod;
        return (int) result;
    }

private:
    long long factorial(int k, long long mod) {
        long long res = 1;
        for (int i = 2; i <= k; i++) {
            res = (res * i) % mod;
        }
        return res;
    }
};
```
