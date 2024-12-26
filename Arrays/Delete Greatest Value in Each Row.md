Leetcode Question: [Delete Greatest Value in Each Row](https://leetcode.com/problems/delete-greatest-value-in-each-row/)

### Java
```java
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, ans = 0;
        int count = cols;
        int maxLocal = 0, maxCol = -1, max = 0;

        while (count-- > 0) {
            max = 0;
            for (int i = 0; i < rows; i++) {
                maxLocal = 0;
                for (int j = 0; j < cols; j++) {
                    if(grid[i][j] > maxLocal) {
                        maxLocal = grid[i][j];
                        maxCol = j;
                    }
                }
                grid[i][maxCol] = -1;
                max = max < maxLocal ? maxLocal : max;
            }
            ans += max;
        }
        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        int rows = grid.size(), cols = grid[0].size(), ans = 0;
        int count = cols;
        int maxLocal = 0, maxCol = -1, max = 0;

        while (count-- > 0) {
            max = 0;
            for (int i = 0; i < rows; i++) {
                maxLocal = 0;
                for (int j = 0; j < cols; j++) {
                    if(grid[i][j] > maxLocal) {
                        maxLocal = grid[i][j];
                        maxCol = j;
                    }
                }
                grid[i][maxCol] = -1;
                max = max < maxLocal ? maxLocal : max;
            }
            ans += max;
        }
        return ans;
    }
};
```
