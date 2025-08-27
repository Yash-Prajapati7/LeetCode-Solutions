Leetcode Question : [Length of Longest V-Shaped Diagonal Segment](https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/)

### Java

```java
class Solution {
    private static final int[][] dirs = {
            { 1, 1 },
            { 1, -1 },
            { -1, -1 },
            { -1, 1 },
    };

    private static int[][][][] memo;
    private int rows, cols;
    private int[][] grid;

    private int dfs(int x, int y, int direction, int turned, int target) {
        int nx = x + dirs[direction][0];
        int ny = y + dirs[direction][1];

        if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != target) {
            return 0;
        }

        if (memo[nx][ny][direction][turned] != -1) {
            return memo[nx][ny][direction][turned];
        }

        int maxStep = dfs(nx, ny, direction, turned, 2 - target);
        if (turned == 1) {
            int temp = dfs(nx, ny, (direction + 1) % 4, 0, 2 - target);
            if (temp > maxStep) {
                maxStep = temp;
            }
        }

        memo[nx][ny][direction][turned] = maxStep + 1;
        return maxStep + 1;
    }

    public int lenOfVDiagonal(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.memo = new int[rows][cols][4][2];
        this.grid = grid;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 2; l++) {
                        memo[i][j][k][l] = -1;
                    }
                }
            }
        }

        int current = 0, result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int direction = 0; direction < 4; direction++) {
                        current = dfs(i, j, direction, 1, 2) + 1;
                        if (current > result) {
                            result = current;
                        }
                    }
                }
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
private:
    const vector<vector<int>> dirs = {
        {1, 1},
        {1, -1},
        {-1, -1},
        {-1, 1}
    };
    vector<vector<vector<vector<int>>>> memo;
    vector<vector<int>> grid;
    int rows, cols;

    int dfs(int x, int y, int direction, int turned, int target) {
        int nx = x + dirs[direction][0];
        int ny = y + dirs[direction][1];

        if(nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != target)
            return 0;

        if(memo[nx][ny][direction][turned] != -1)
            return memo[nx][ny][direction][turned];

        int maxStep = dfs(nx, ny, direction, turned, 2 - target);
        if(turned == 1) {
            int temp = dfs(nx, ny, (direction + 1) % 4, 0, 2 - target);
            if(temp > maxStep) maxStep = temp;
        }

        memo[nx][ny][direction][turned] = maxStep + 1;
        return maxStep + 1;
    }

public:
    int lenOfVDiagonal(vector<vector<int>>& gridInput) {
        grid = gridInput;
        rows = grid.size();
        cols = grid[0].size();
        memo = vector<vector<vector<vector<int>>>>(rows, vector<vector<vector<int>>>(cols, vector<vector<int>>(4, vector<int>(2, -1))));
        
        int result = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    for(int direction = 0; direction < 4; direction++) {
                        int current = dfs(i, j, direction, 1, 2) + 1;
                        result = max(result, current);
                    }
                }
            }
        }
        return result;
    }
};
```
