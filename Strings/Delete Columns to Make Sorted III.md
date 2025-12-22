Leetcode Question : [Delete Columns to Make Sorted III](https://leetcode.com/problems/delete-columns-to-make-sorted-iii)

### Java

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int totalRows = strs.length;
        int totalCols = strs[0].length();
        int[] dp = new int[totalCols];
        Arrays.fill(dp, 1);

        for (int startCol = totalCols - 2; startCol >= 0; startCol--) {
            toNextCol:
            for (int nextCol = startCol + 1; nextCol < totalCols; nextCol++) {
                // checking that startCol <= nextCol for all rows
                for (int row = 0; row < totalRows; row++) {
                    if (strs[row].charAt(startCol) > strs[row].charAt(nextCol)) {
                        continue toNextCol;
                    }
                }
                dp[startCol] = (dp[startCol] < dp[nextCol] + 1) ? dp[nextCol] + 1 : dp[startCol];
            }
        }

        int max = 0;
        for (int i = 0; i < totalCols; i++) {
            max = (max < dp[i]) ? dp[i] : max;
        }

        return totalCols - max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int totalRows = strs.size();
        int totalCols = strs[0].size();
        vector<int> dp(totalCols, 1);

        for (int startCol = totalCols - 2; startCol >= 0; startCol--) {
            for (int nextCol = startCol + 1; nextCol < totalCols; nextCol++) {
                bool valid = true;
                // checking that startCol <= nextCol for all rows
                for (int row = 0; row < totalRows; row++) {
                    if (strs[row][startCol] > strs[row][nextCol]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[startCol] = max(dp[startCol], dp[nextCol] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int x : dp) {
            maxLen = max(maxLen, x);
        }

        return totalCols - maxLen;
    }
};
```
