Leetcode Question : [Path With Maximum Gold](https://leetcode.com/problems/path-with-maximum-gold)

### Java

```java
class Solution {
    private final int[] dirs = new int[] { 0, 1, 0, -1, 0 };

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxGold = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentGold = dfs(grid, rows, cols, row, col);
                maxGold = Math.max(maxGold, currentGold);
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        int temp = grid[row][col];
        grid[row][col] = 0;

        int maxGold = 0;
        for (int i = 0; i < 4; i++) {
            int nextGold = dfs(grid, rows, cols, row + dirs[i], col + dirs[i + 1]);
            maxGold = Math.max(maxGold, nextGold);
        }

        grid[row][col] = temp;
        return temp + maxGold;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    vector<int> dirs = {0, 1, 0, -1, 0};

public:
    int getMaximumGold(vector<vector<int>>& grid) {
        int rows = grid.size(), cols = grid[0].size();
        int maxGold = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentGold = dfs(grid, rows, cols, row, col);
                maxGold = max(maxGold, currentGold);
            }
        }

        return maxGold;
    }

private:
    int dfs(vector<vector<int>>& grid, int rows, int cols, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        int temp = grid[row][col];
        grid[row][col] = 0;

        int maxGold = 0;
        for (int i = 0; i < 4; i++) {
            int nextGold = dfs(grid, rows, cols, row + dirs[i], col + dirs[i + 1]);
            maxGold = max(maxGold, nextGold);
        }

        grid[row][col] = temp;
        return temp + maxGold;
    }
};
```
