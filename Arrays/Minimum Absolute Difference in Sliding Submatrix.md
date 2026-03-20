Leetcode Question : [Minimum Absolute Difference in Sliding Submatrix](https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/)

### Java

```java
class Solution {
    private int calculate(int[][] grid, int x, int y, int k) {
        List<Integer> kgrid = new ArrayList<>();
        for(int i = x; i < (x + k); i++) {
            for(int j = y; j < (y + k); j++) {
                kgrid.add(grid[i][j]);
            }
        }

        Collections.sort(kgrid);
        int kmin = Integer.MAX_VALUE;
        for(int i = 1; i < (k * k); i++) {
            if(!kgrid.get(i).equals(kgrid.get(i - 1))) {
                kmin = Math.min(kmin, kgrid.get(i) - kgrid.get(i - 1));
            }
        }

        return kmin == Integer.MAX_VALUE ? 0 : kmin;        
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rows = m - k + 1, cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans[i][j] = calculate(grid, i, j, k);
            }
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int calculate(vector<vector<int>>& grid, int x, int y, int k) {
        vector<int> kgrid;
        for(int i = x; i < (x + k); i++) {
            for(int j = y; j < (y + k); j++) {
                kgrid.push_back(grid[i][j]);
            }
        }

        sort(kgrid.begin(), kgrid.end());
        int kmin = INT_MAX;
        for(int i = 1; i < (k * k); i++) {
            if(kgrid[i] != kgrid[i - 1]) {
                kmin = min(kmin, kgrid[i] - kgrid[i - 1]);
            }
        }

        return kmin == INT_MAX ? 0 : kmin;        
    }

    vector<vector<int>> minAbsDiff(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        int rows = m - k + 1, cols = n - k + 1;
        vector<vector<int>> ans(rows, vector<int>(cols));

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans[i][j] = calculate(grid, i, j, k);
            }
        }

        return ans;
    }
};
```
