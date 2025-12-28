Leetcode Question : [Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

### Java

```java
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[m - 1][n - 1] >= 0) {
            return 0;
        }

        int result = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                result++;
            }
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
    int countNegatives(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        if (grid[m - 1][n - 1] >= 0) {
            return 0;
        }

        int result = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                result++;
            }
        }

        return result;
    }
};
```
