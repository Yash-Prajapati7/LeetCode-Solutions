Leetcode Question : [Count Odd Numbers in an Interval Range](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range)

### Java

```java
class Solution {
    public int countOdds(int low, int high) {
        int result = (high - low) >> 1;
        if(high % 2 != 0 || low % 2 != 0) {
            result++;
        }
        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countOdds(int low, int high) {
        int result = (high - low) >> 1;
        if(high % 2 != 0 || low % 2 != 0) {
            result++;
        }
        return result;
    }
};
```
