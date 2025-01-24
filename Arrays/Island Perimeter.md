Leetcode Question: [Island Perimeter](https://leetcode.com/problems/island-perimeter/)

### Java
```java
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += (i == 0 ? 1 : (grid[i - 1][j] == 0 ? 1 : 0));    // Check for the previous row in the same column
                    ans += (i == m - 1 ? 1 : (grid[i + 1][j] == 0 ? 1 : 0));    // Check for the next row in the same column
                    ans += (j == 0 ? 1 : (grid[i][j - 1] == 0 ? 1 : 0));    // Check for the previous column in the same row
                    ans += (j == n - 1 ? 1 : (grid[i][j + 1] == 0 ? 1 : 0));    // Check for the next column in the same row
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
    int islandPerimeter(vector<vector<int>>& grid) {
        int ans = 0;
        int m = grid.size(), n = grid[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += (i == 0 ? 1 : (grid[i - 1][j] == 0 ? 1 : 0));    // Check for the previous row in the same column
                    ans += (i == m - 1 ? 1 : (grid[i + 1][j] == 0 ? 1 : 0));    // Check for the next row in the same column
                    ans += (j == 0 ? 1 : (grid[i][j - 1] == 0 ? 1 : 0));    // Check for the previous column in the same row
                    ans += (j == n - 1 ? 1 : (grid[i][j + 1] == 0 ? 1 : 0));    // Check for the next column in the same row
                }
            }
        }

        return ans;
    }
};
```
