### Leetcode Question : [Stone Game III](https://leetcode.com/problems/stone-game-iii/)

### Java

```java id="z8h2qm"
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n + 1];
        dp[n] = 0;

        int take1, take2, take3;

        for (int i = n - 1; i >= 0; i--) {

            take1 = stoneValue[i] - dp[i + 1];

            take2 = Integer.MIN_VALUE;
            if (i + 1 < n) {
                take2 = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            }

            take3 = Integer.MIN_VALUE;
            if (i + 2 < n) {
                take3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            }

            dp[i] = Math.max(take1, Math.max(take2, take3));
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
```

### C++

```cpp id="p4v9kr"
using namespace std;

class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        int n = stoneValue.size();

        vector<int> dp(n + 1, 0);

        int take1, take2, take3;

        for (int i = n - 1; i >= 0; i--) {

            take1 = stoneValue[i] - dp[i + 1];

            take2 = INT_MIN;
            if (i + 1 < n) {
                take2 = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            }

            take3 = INT_MIN;
            if (i + 2 < n) {
                take3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            }

            dp[i] = max(take1, max(take2, take3));
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
};
```
