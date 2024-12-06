Leetcode Question: [Maximum Number of Integers to Choose From a Range I](https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/)

### Java
```java
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] isBanned = new boolean[10001];
        for (int ban : banned) {
            isBanned[ban] = true;
        }

        int totalSum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isBanned[i] && totalSum + i <= maxSum) {
                totalSum += i;
                count++;
            }
        }

        return count;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        vector<bool> isBanned(10001, false);
        for (int ban : banned) {
            isBanned[ban] = true;
        }

        int totalSum = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isBanned[i] && totalSum + i <= maxSum) {
                totalSum += i;
                count++;
            }
        }

        return count;
    }
};
```
