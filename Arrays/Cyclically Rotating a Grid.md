Leetcode Question : [Cyclically Rotating a Grid](https://leetcode.com/problems/cyclically-rotating-a-grid/)

### Java

```java
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int nlayer = Math.min(m >> 1, n >> 1);

        for (int layer = 0; layer < nlayer; layer++) {

            int total = 2 * ((m - 2 * layer) + (n - 2 * layer)) - 4;

            int[] r = new int[total];
            int[] c = new int[total];
            int[] val = new int[total];

            int idx = 0;

            // left
            for (int i = layer; i < m - layer - 1; i++) {
                r[idx] = i;
                c[idx] = layer;
                val[idx] = grid[i][layer];
                idx++;
            }

            // down
            for (int j = layer; j < n - layer - 1; j++) {
                r[idx] = m - layer - 1;
                c[idx] = j;
                val[idx] = grid[m - layer - 1][j];
                idx++;
            }

            // right
            for (int i = m - layer - 1; i > layer; i--) {
                r[idx] = i;
                c[idx] = n - layer - 1;
                val[idx] = grid[i][n - layer - 1];
                idx++;
            }

            // up
            for (int j = n - layer - 1; j > layer; j--) {
                r[idx] = layer;
                c[idx] = j;
                val[idx] = grid[layer][j];
                idx++;
            }

            int kk = k % total;

            for (int i = 0; i < total; i++) {
                int newIdx = (i + total - kk) % total;
                grid[r[i]][c[i]] = val[newIdx];
            }
        }

        return grid;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();

        int nlayer = min(m >> 1, n >> 1);

        for (int layer = 0; layer < nlayer; layer++) {

            int total = 2 * ((m - 2 * layer) + (n - 2 * layer)) - 4;

            vector<int> r(total);
            vector<int> c(total);
            vector<int> val(total);

            int idx = 0;

            // left
            for (int i = layer; i < m - layer - 1; i++) {
                r[idx] = i;
                c[idx] = layer;
                val[idx] = grid[i][layer];
                idx++;
            }

            // down
            for (int j = layer; j < n - layer - 1; j++) {
                r[idx] = m - layer - 1;
                c[idx] = j;
                val[idx] = grid[m - layer - 1][j];
                idx++;
            }

            // right
            for (int i = m - layer - 1; i > layer; i--) {
                r[idx] = i;
                c[idx] = n - layer - 1;
                val[idx] = grid[i][n - layer - 1];
                idx++;
            }

            // up
            for (int j = n - layer - 1; j > layer; j--) {
                r[idx] = layer;
                c[idx] = j;
                val[idx] = grid[layer][j];
                idx++;
            }

            int kk = k % total;

            for (int i = 0; i < total; i++) {
                int newIdx = (i + total - kk) % total;
                grid[r[i]][c[i]] = val[newIdx];
            }
        }

        return grid;
    }
};
```
