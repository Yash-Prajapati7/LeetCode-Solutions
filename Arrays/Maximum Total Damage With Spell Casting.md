Leetcode Question : [Maximum Total Damage With Spell Casting](https://leetcode.com/problems/maximum-total-damage-with-spell-casting/)

### Java

```java
import java.util.*;

class Solution {

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : power) {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }

        int n = count.size() + 1;
        int[][] vec = new int[n][2];
        vec[0][0] = -1000000000;
        vec[0][1] = 0;

        int idx = 1;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            vec[idx][0] = e.getKey();
            vec[idx][1] = e.getValue();
            idx++;
        }

        long[] dp = new long[n];
        long maxTillNow = 0, result = 0;
        int j = 1;

        for (int i = 1; i < n; i++) {
            while (j < i && vec[j][0] < vec[i][0] - 2) {
                maxTillNow = Math.max(maxTillNow, dp[j]);
                j++;
            }
            dp[i] = maxTillNow + 1L * vec[i][0] * vec[i][1];
            result = Math.max(result, dp[i]);
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
    long long maximumTotalDamage(vector<int>& power) {
        map<int, int> count;
        for (int p : power) {
            count[p]++;
        }

        int n = count.size() + 1;
        vector<pair<int, int>> vec(n);
        vec[0] = {-1000000000, 0};

        int idx = 1;
        for (auto& e : count) {
            vec[idx++] = {e.first, e.second};
        }

        vector<long long> dp(n, 0);
        long long maxTillNow = 0, result = 0;
        int j = 1;

        for (int i = 1; i < n; i++) {
            while (j < i && vec[j].first < vec[i].first - 2) {
                maxTillNow = max(maxTillNow, dp[j]);
                j++;
            }
            dp[i] = maxTillNow + 1LL * vec[i].first * vec[i].second;
            result = max(result, dp[i]);
        }

        return result;
    }
};
```
