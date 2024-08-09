Leetcode Question : [Magic Squares In Grid](https://leetcode.com/problems/magic-squares-in-grid/description/)

### Java
```java
class Solution {
    private int isMagic(int[][] grid, int row, int col) {
        // Ensure grid[i][j] is between 1 to 9
        HashSet<Integer> values = new HashSet<>();
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                if(values.contains(grid[i][j]) || !(grid[i][j] >=1 && grid[i][j] <= 9)) {
                    return 0;
                }
                values.add(grid[i][j]);
            }
        }
        
        // Get sum of each row
        for(int i = row; i < row + 3; i++) {
            if(grid[i][col] + grid[i][col + 1] + grid[i][col + 2] != 15) {
                return 0;
            }
        }

        // Get sum of each column
        for(int i = col; i < col + 3; i++) {
            if(grid[row][i] + grid[row + 1][i] + grid[row + 2][i] != 15) {
                return 0;
            }
        }

        // Check for diagonals
        if((grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != 15) || (grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2] != 15)) {
            return 0;
        }

        return 1;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        for(int i = 0; i < rows - 2; i++) {
            for(int j = 0; j < cols - 2; j++) {
                result += isMagic(grid, i, j);
            }
        }

        return result;
    }
}
```

### C++
```cpp
class Solution {
private:
    int isMagic(vector<vector<int>>& grid, int row, int col) {
        // Ensure grid[i][j] is between 1 to 9
        unordered_set<int> values;
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                if(values.count(grid[i][j]) || !(grid[i][j] >=1 && grid[i][j] <= 9)) {
                    return 0;
                }
                values.insert(grid[i][j]);
            }
        }
        
        // Get sum of each row
        for(int i = row; i < row + 3; i++) {
            if(grid[i][col] + grid[i][col + 1] + grid[i][col + 2] != 15) {
                return 0;
            }
        }

        // Get sum of each column
        for(int i = col; i < col + 3; i++) {
            if(grid[row][i] + grid[row + 1][i] + grid[row + 2][i] != 15) {
                return 0;
            }
        }

        // Check for diagonals
        if((grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != 15) || (grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2] != 15)) {
            return 0;
        }

        return 1;
    }
    
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        int result = 0;

        for(int i = 0; i < rows - 2; i++) {
            for(int j = 0; j < cols - 2; j++) {
                result += isMagic(grid, i, j);
            }
        }

        return result;
    }
};
```
