Leetcode Question : [Number of Ways to Paint N × 3 Grid](https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/)

### Java

```java
class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;

        // The type of pattern for a row
        long aba = 6;    // pattern R-G-R or Y-R-Y etc
        long abc = 6;    // pattern R-G-Y or G-R-Y etc

        long nextABA = 0, nextABC = 0;

        for(int i = 2; i <= n; i++) {   // begin from row 2
            nextABA = ((3 * aba) + (2 * abc)) % MOD;
            nextABC = ((2 * aba) + (2 * abc)) % MOD;
            aba = nextABA;
            abc = nextABC;
        }

        return (int)(aba + abc) % MOD;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numOfWays(int n) {
        int MOD = 1000000007;

        long long aba = 6;
        long long abc = 6;

        long long nextABA = 0, nextABC = 0;

        for(int i = 2; i <= n; i++) {
            nextABA = ((3 * aba) + (2 * abc)) % MOD;
            nextABC = ((2 * aba) + (2 * abc)) % MOD;
            aba = nextABA;
            abc = nextABC;
        }

        return (int)((aba + abc) % MOD);
    }
};
```
