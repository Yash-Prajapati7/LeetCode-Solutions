Leetcode Question: [Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)

### Java

```java
class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumMatrix = new int[rows + 1][cols + 1]; // Extra row and column for easier prefix sum computation

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                sumMatrix[i][j] = matrix[i - 1][j - 1] +
                                  sumMatrix[i - 1][j] +
                                  sumMatrix[i][j - 1] -
                                  sumMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] -
               sumMatrix[row1][col2 + 1] -
               sumMatrix[row2 + 1][col1] +
               sumMatrix[row1][col1];
    }
}
```

### CPP

```cpp
class NumMatrix {
private:
    vector<vector<int>> sumMatrix;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) return;
        int rows = matrix.size();
        int cols = matrix[0].size();
        sumMatrix.resize(rows + 1, vector<int>(cols + 1, 0));

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                sumMatrix[i][j] = matrix[i - 1][j - 1] +
                                  sumMatrix[i - 1][j] +
                                  sumMatrix[i][j - 1] -
                                  sumMatrix[i - 1][j - 1];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] -
               sumMatrix[row1][col2 + 1] -
               sumMatrix[row2 + 1][col1] +
               sumMatrix[row1][col1];
    }
};
```
