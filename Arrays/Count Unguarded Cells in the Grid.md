Leetcode Question : [Count Unguarded Cells in the Grid](https://leetcode.com/problems/count-unguarded-cells-in-the-grid/)

### Java

```java
class Solution {

    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = GUARD;
        }

        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = WALL;
        }

        // Directions: up, down, left, right
        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // For each guard, extend visibility in all directions
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];

                while (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == WALL || grid[x][y] == GUARD) break;
                    if (grid[x][y] == UNGUARDED) grid[x][y] = GUARDED;
                    x += d[0];
                    y += d[1];
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == UNGUARDED) count++;
            }
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    static const int UNGUARDED = 0;
    static const int GUARDED = 1;
    static const int GUARD = 2;
    static const int WALL = 3;

public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        vector<vector<int>> grid(m, vector<int>(n, UNGUARDED));

        // Mark guards
        for (auto& g : guards) {
            grid[g[0]][g[1]] = GUARD;
        }

        // Mark walls
        for (auto& w : walls) {
            grid[w[0]][w[1]] = WALL;
        }

        // Directions: up, down, left, right
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // For each guard, extend visibility in all directions
        for (auto& g : guards) {
            for (auto& d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];

                while (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == WALL || grid[x][y] == GUARD) break;
                    if (grid[x][y] == UNGUARDED) grid[x][y] = GUARDED;
                    x += d[0];
                    y += d[1];
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == UNGUARDED) count++;
            }
        }

        return count;
    }
};
```
