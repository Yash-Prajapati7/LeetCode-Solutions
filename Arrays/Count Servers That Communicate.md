Leetcode Question: [Count Servers That Communicate](https://leetcode.com/problems/count-servers-that-communicate/)

### Java
```java
class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int ans = 0, server = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    if(rows[i] > 1 || cols[j] > 1) ans++;
                }
            }
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        int ans = 0, server = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (rows[i] > 1 || cols[j] > 1) ans++;
                }
            }
        }

        return ans;
    }
};
```
