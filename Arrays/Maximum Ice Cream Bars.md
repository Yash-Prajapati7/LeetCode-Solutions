Leetcode Question : [Maximum Ice Cream Bars](https://leetcode.com/problems/maximum-ice-cream-bars)

### Java

```java
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if(costs.length == 1) {
            return costs[0] <= coins ? 1 : 0;
        }
        
        Arrays.sort(costs);
        int ans = 0;

        for(int i = 0; i < costs.length; i++) {
            if(coins - costs[i] >= 0) {
                ans++;
                coins -= costs[i];
            } else {
                break;
            }
        }

        return ans;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        if (costs.size() == 1) {
            return costs[0] <= coins ? 1 : 0;
        }

        sort(costs.begin(), costs.end());

        int ans = 0;

        for (int i = 0; i < costs.size(); i++) {
            if (coins - costs[i] >= 0) {
                ans++;
                coins -= costs[i];
            } else {
                break;
            }
        }

        return ans;
    }
};
```
