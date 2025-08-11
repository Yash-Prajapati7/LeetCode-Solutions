Leetcode Question : [Range Product Queries of Powers](https://leetcode.com/problems/range-product-queries-of-powers/)

### Java

```java
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;

        // Step 1: Collect the actual powers of 2 present in n
        List<Integer> powers = new ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(1 << bit); // store power of two
            }
            bit++;
            n >>= 1;
        }

        // Step 2: Build prefix product array modulo mod
        int[] prefix = new int[powers.size()];
        prefix[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (int) ((1L * prefix[i - 1] * powers.get(i)) % mod);
        }

        // Step 3: Answer queries
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];
            if (l == 0) {
                result[k] = prefix[r];
            } else {
                long numerator = prefix[r];
                long denominator = prefix[l - 1];
                long inv = modInverse(denominator, mod - 2, mod);
                result[k] = (int) ((numerator * inv) % mod);
            }
        }

        return result;
    }

    // Modular exponentiation for inverse
    private long modInverse(long base, int exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
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
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        int mod = 1000000007;

        // Step 1: Collect the actual powers of 2 present in n
        vector<int> powers;
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.push_back(1 << bit); // store power of two
            }
            bit++;
            n >>= 1;
        }

        // Step 2: Build prefix product array modulo mod
        vector<int> prefix(powers.size());
        prefix[0] = powers[0];
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (1LL * prefix[i - 1] * powers[i]) % mod;
        }

        // Step 3: Answer queries
        vector<int> result(queries.size());
        for (int k = 0; k < queries.size(); k++) {
            int l = queries[k][0];
            int r = queries[k][1];
            if (l == 0) {
                result[k] = prefix[r];
            } else {
                long numerator = prefix[r];
                long denominator = prefix[l - 1];
                long inv = modInverse(denominator, mod - 2, mod);
                result[k] = (numerator * inv) % mod;
            }
        }

        return result;
    }

private:
    long modInverse(long base, int exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
};
```
