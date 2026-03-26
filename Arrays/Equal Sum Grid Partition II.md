Leetcode Question : [Equal Sum Grid Partition II](https://leetcode.com/problems/equal-sum-grid-partition-ii)

### Java

```java
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length, n = grid[0].length;
        long tag = 0;

        // compute total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // try all 4 orientations
        for (int k = 0; k < 4; k++) {
            Set<Long> exist = new HashSet<>();
            exist.add(0L);

            long sum = 0;
            m = grid.length;
            n = grid[0].length;

            // if only 1 row → rotate
            if (m == 1) {
                grid = rotate(grid);
                continue;
            }

            // special case: single column
            if (n == 1) {
                for (int i = 0; i < m - 1; i++) {
                    sum += grid[i][0];
                    tag = (sum << 1) - total;

                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
                        return true;
                    }
                }
                grid = rotate(grid);
                continue;
            }

            // general case
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    sum += grid[i][j];
                    exist.add((long) grid[i][j]);
                }

                tag = (sum << 1) - total;

                // first row → only boundary removals safe
                if (i == 0) {
                    if (tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]) {
                        return true;
                    }
                } else {
                    if (exist.contains(tag)) {
                        return true;
                    }
                }
            }

            // rotate grid for next orientation
            grid = rotate(grid);
        }

        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rotated = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = grid[i][j];
            }
        }

        return rotated;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        long long total = 0;
        int m = grid.size(), n = grid[0].size();
        long long tag = 0;

        // compute total sum
        for (auto &row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // try all 4 orientations
        for (int k = 0; k < 4; k++) {
            unordered_set<long long> exist;
            exist.insert(0LL);

            long long sum = 0;
            m = grid.size();
            n = grid[0].size();

            // if only 1 row → rotate
            if (m == 1) {
                grid = rotate(grid);
                continue;
            }

            // special case: single column
            if (n == 1) {
                for (int i = 0; i < m - 1; i++) {
                    sum += grid[i][0];
                    tag = (sum << 1) - total;

                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
                        return true;
                    }
                }
                grid = rotate(grid);
                continue;
            }

            // general case
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    sum += grid[i][j];
                    exist.insert((long long)grid[i][j]);
                }

                tag = (sum << 1) - total;

                // first row → only boundary removals safe
                if (i == 0) {
                    if (tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]) {
                        return true;
                    }
                } else {
                    if (exist.count(tag)) {
                        return true;
                    }
                }
            }

            // rotate grid for next orientation
            grid = rotate(grid);
        }

        return false;
    }

    vector<vector<int>> rotate(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> rotated(n, vector<int>(m));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = grid[i][j];
            }
        }

        return rotated;
    }
};
```
