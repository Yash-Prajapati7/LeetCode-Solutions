Leetcode Question : [Minimum Cost to Reach Every Position](https://leetcode.com/problems/minimum-cost-to-reach-every-position/)

### Java
```java
class Solution {
    public int[] minCosts(int[] cost) {
        for(int i = 1; i < cost.length; i++) {
            cost[i] = cost[i - 1] < cost[i] ? cost[i - 1] : cost[i];
        }
        return cost;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> minCosts(vector<int>& cost) {
        for(int i = 1; i < cost.size(); i++) {
            cost[i] = cost[i - 1] < cost[i] ? cost[i - 1] : cost[i];
        }
        return cost;
    }
};
```
