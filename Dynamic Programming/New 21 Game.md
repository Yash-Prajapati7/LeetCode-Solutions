Leetcode Question : [New 21 Game](https://leetcode.com/problems/new-21-game)

### Java

```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0) {
            return 1;
        }

        double dp[] = new double[n + 1];
        dp[0] = 1;
        double s = 1.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            
            if (i < k) {
                s += dp[i];
            }

            if (i - maxPts >= 0 && i - maxPts < k) {
                s -= dp[i - maxPts];
            }
        }

        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        if(k == 0) {
            return 1;
        }

        vector<double> dp(n + 1, 0.0);
        dp[0] = 1.0;
        double s = 1.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            
            if (i < k) {
                s += dp[i];
            }

            if (i - maxPts >= 0 && i - maxPts < k) {
                s -= dp[i - maxPts];
            }
        }

        double ans = 0.0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
};
```
