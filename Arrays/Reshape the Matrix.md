Leetcode Question : [Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/)

### Java
```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if((r * c) != (rows * cols) || (r == rows && c == cols)) return mat;
        
        int[][] result = new int[r][c];
        int pos = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[pos/c][pos % c] = mat[i][j];
                pos++;
            }
        }

        return result;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        int rows = mat.size();
        int cols = mat[0].size();
        if((r * c) != (rows * cols) || (r == rows && c == cols)) return mat;
        
        vector<vector<int>> result(r, vector<int>(c));
        int pos = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[pos/c][pos % c] = mat[i][j];
                pos++;
            }
        }

        return result;
    }
};
```
