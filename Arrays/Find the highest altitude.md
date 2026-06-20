Leetcode Question : [Find the Highest Altitude](https://leetcode.com/problems/find-the-highest-altitude/)

### Java

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prev = gain[0];
        int n = gain.length;

        for(int i = 1; i < n; i++) {
            prev = prev + gain[i];
            max = (max < prev) ? prev : max;
        }

        return max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int maxAlt = 0;
        int prev = gain[0];
        int n = gain.size();

        for (int i = 1; i < n; i++) {
            prev = prev + gain[i];
            maxAlt = (maxAlt < prev) ? prev : maxAlt;
        }

        return maxAlt;
    }
};
```
