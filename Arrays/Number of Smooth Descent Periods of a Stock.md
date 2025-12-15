Leetcode Question : [Number of Smooth Descent Periods of a Stock](https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/)

### Java

```java
class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long result = 1;
        int ptr1 = 0, ptr2 = 1;
        long current = 1;

        while (ptr2 < n) {
            if (prices[ptr2 - 1] - prices[ptr2] == 1) {
                current = ptr2 - ptr1 + 1;
            } else {
                ptr1 = ptr2;
                result += ((current * (current + 1)) >> 1);
                current = 1;
            }
            ptr2++;
        }

        if (current != 1) {
            result += ((current * (current + 1)) >> 1) - 1;
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
    long long getDescentPeriods(vector<int>& prices) {
        int n = prices.size();
        long long result = 1;
        int ptr1 = 0, ptr2 = 1;
        long long current = 1;

        while (ptr2 < n) {
            if (prices[ptr2 - 1] - prices[ptr2] == 1) {
                current = ptr2 - ptr1 + 1;
            } else {
                ptr1 = ptr2;
                result += ((current * (current + 1)) >> 1);
                current = 1;
            }
            ptr2++;
        }

        if (current != 1) {
            result += ((current * (current + 1)) >> 1) - 1;
        }

        return result;
    }
};
```
