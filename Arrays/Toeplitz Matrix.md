Leetcode Question : [Toeplitz Matrix](https://leetcode.com/problems/toeplitz-matrix/)

### Java
```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows - 1; i++) {
            for(int j = 0; j < cols - 1; j++) {
                if(matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }            
        }
        
        return true;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        for(int i = 0; i < rows - 1; i++) {
            for(int j = 0; j < cols - 1; j++) {
                if(matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
};
```
