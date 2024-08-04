Leetcode Question : [Minimum Cost of Buying Candies With Discount](https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/)
### Java
```java
import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int currentCost = 0;
        int i;
        for(i = cost.length - 1; i >=1; i -= 3) {
            currentCost += (cost[i] + cost[i - 1]);
        }

        if(i == 0) {
            currentCost += cost[i];
        }
        
        return currentCost;
    }
}
```

### C++
```cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    int minimumCost(std::vector<int>& cost) {
        std::sort(cost.begin(), cost.end());
        int currentCost = 0;
        int i;
        for (i = cost.size() - 1; i >= 1; i -= 3) {
            currentCost += (cost[i] + cost[i - 1]);
        }

        if (i == 0) {
            currentCost += cost[i];
        }
        
        return currentCost;
    }
};
```
