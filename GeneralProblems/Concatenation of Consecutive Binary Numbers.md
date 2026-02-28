Leetcode Question : [Concatenation of Consecutive Binary Numbers](https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/)

### Java

```java
class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long result = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            result = ((result << bitLength) | i) % mod;
        }

        return (int) result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int concatenatedBinary(int n) {
        int mod = 1000000007;
        long long result = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            result = ((result << bitLength) | i) % mod;
        }

        return (int) result;
    }
};
```
