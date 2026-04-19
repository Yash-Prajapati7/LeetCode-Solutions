Leetcode Question : [Mirror Distance of an Integer](https://leetcode.com/problems/mirror-distance-of-an-integer/)

### Java

```java
class Solution {
    public int mirrorDistance(int n) {
        if(n < 10) return 0;
        
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        return n > reverse ? n - reverse : reverse - n;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int mirrorDistance(int n) {
        if(n < 10) return 0;
        
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        return n > reverse ? n - reverse : reverse - n;
    }
};
```
