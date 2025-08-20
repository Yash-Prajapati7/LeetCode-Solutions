Leetcode Question : [Maximal Square](https://leetcode.com/problems/maximal-square/)

### Java

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r + 1][c + 1];
        int max = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    max = max < dp[i + 1][j + 1] ? dp[i + 1][j + 1] : max;
                }
            }
        }

        return max * max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int r = matrix.size(), c = matrix[0].size();
        vector<vector<int>> dp(r + 1, vector<int>(c + 1, 0));
        int maxVal = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = min({dp[i][j], dp[i + 1][j], dp[i][j + 1]}) + 1;
                    maxVal = max(maxVal, dp[i + 1][j + 1]);
                }
            }
        }

        return maxVal * maxVal;
    }
};
```
