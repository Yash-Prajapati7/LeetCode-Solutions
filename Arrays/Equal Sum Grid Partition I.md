Leetcode Question : [Equal Sum Grid Partition I](https://leetcode.com/problems/equal-sum-grid-partition-i/)

### Java

```java
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        long current = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                current += grid[i][j];
            }

            if((current << 1) == total) return true;
        }

        current = 0;    // reset current for vertical line

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                current += grid[i][j];
            }

            if((current << 1) == total) return true;
        }

        return false;
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

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        long long current = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                current += grid[i][j];
            }

            if((current << 1) == total) return true;
        }

        current = 0;    // reset current for vertical line

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                current += grid[i][j];
            }

            if((current << 1) == total) return true;
        }

        return false;
    }
};
```
