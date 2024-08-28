Leetcode Question: [Count Sub Islands](https://leetcode.com/problems/count-sub-islands/)

### Java
```java
class Solution {
    private boolean dfs(int[][] grid1, int [][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        if(i >= m || j >= n || i < 0 || j < 0 || grid2[i][j] == 0) {
            return true;
        }
        if(grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;

        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean left = dfs(grid1, grid2, i, j - 1);

        return up && down && right && left;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1) {
                    if(dfs(grid1, grid2, i, j)) {
                        count++;
                    }    
                }
            }
        }

        return count;
    }
}
```

### C++
```cpp
class Solution {
private:
    bool dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int i, int j) {
        int m = grid1.size();
        int n = grid1[0].size();

        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return true;
        }
        if (grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;

        bool up = dfs(grid1, grid2, i - 1, j);
        bool down = dfs(grid1, grid2, i + 1, j);
        bool right = dfs(grid1, grid2, i, j + 1);
        bool left = dfs(grid1, grid2, i, j - 1);

        return up && down && right && left;
    }

public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid1.size();
        int n = grid1[0].size();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j] == 1) {
                    if(dfs(grid1, grid2, i, j)) {
                        count++;
                    }    
                }
            }
        }

        return count;
    }
};
```

The `dfs` (Depth-First Search) function in this code is used to explore and verify whether a piece of land in `grid2` is a "sub-island" of the corresponding piece of land in `grid1`. Here's a breakdown of how the logic works:
The `dfs` function explores the islands in `grid2` recursively to determine whether they are sub-islands of `grid1`.

#### Steps in the DFS Function

1. **Boundary and Base Conditions Check:**
   ```cpp
   if (i >= m || j >= n || i < 0 || j < 0 || grid2[i][j] == 0) {
       return true;
   }
   if (grid1[i][j] == 0) {
       return false;
   }
   ```
   - **Out-of-Bounds Check:** The first `if` statement checks whether the current cell `(i, j)` is outside the grid boundaries or if it represents water (`grid2[i][j] == 0`). In either case, it returns `true` because moving beyond the grid or encountering water does not invalidate the current sub-island.
   - **Mismatch Check:** The next check (`if (grid1[i][j] == 0)`) verifies if the current cell in `grid1` is water while it is land in `grid2`. If so, it returns `false` because this means `grid2` has land where `grid1` does not, indicating it cannot be a sub-island.

2. **Mark the Current Cell as Visited:**
   ```cpp
   grid2[i][j] = 0;
   ```
   - The current cell in `grid2` is marked as visited by setting it to `0` (water). This prevents revisiting the same cell during the DFS traversal, avoiding infinite loops.

3. **Recursive Calls to Explore Neighboring Cells:**
   ```cpp
   boolean up = dfs(grid1, grid2, i - 1, j);
   boolean down = dfs(grid1, grid2, i + 1, j);
   boolean right = dfs(grid1, grid2, i, j + 1);
   boolean left = dfs(grid1, grid2, i, j - 1);
   ```
   - The function makes four recursive calls to explore the neighboring cells in all four possible directions: up, down, right, and left.
   - These recursive calls continue the search to see if the entire connected land in `grid2` (starting from the current cell) is contained within the land in `grid1`.

4. **Return Combined Result of Neighboring Cells:**
   ```cpp
   return up && down && right && left;
   ```
   - The result of the current DFS exploration is `true` only if all four directions (`up`, `down`, `right`, `left`) also return `true`. This means all parts of the current land in `grid2` are also contained in the corresponding parts of `grid1`.

#### How the `dfs` Function is Used in `countSubIslands`

The `dfs` function is invoked from the `countSubIslands` function:
```java
if(grid2[i][j] == 1) {
    if(dfs(grid1, grid2, i, j)) {
        count++;
    }    
}
```

- **Iteration through All Cells:**
  - The `countSubIslands` function iterates through each cell of `grid2`.
  - When it encounters a `1` (land), it calls `dfs` to check if the entire connected land starting from that cell is a sub-island.
  
- **Increment Count for Valid Sub-Islands:**
  - If the `dfs` call returns `true`, it means the connected land is a valid sub-island, so the `count` is incremented.
