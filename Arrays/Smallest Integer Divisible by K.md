Leetcode Question : [Smallest Integer Divisible by K](https://leetcode.com/problems/smallest-integer-divisible-by-k)

### Java

```java
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int remainder = 0;

        for(int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if(remainder == 0) {
                return length;
            }
        }

        return -1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int remainder = 0;
        for(int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if(remainder == 0) {
                return length;
            }
        }
        return -1;
    }
};
```
