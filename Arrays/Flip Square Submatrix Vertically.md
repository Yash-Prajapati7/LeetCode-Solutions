Leetcode Question : [Flip Square Submatrix Vertically](https://leetcode.com/problems/flip-square-submatrix-vertically)

### Java

```java
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int lastRow = x + k - 1;
        int temp;

        for(int i = x; i < lastRow; i++) {
            for(int j = y; j < y + k; j++) {
                temp = grid[i][j];
                grid[i][j] = grid[lastRow][j];
                grid[lastRow][j] = temp;
            }
            lastRow--;
        }

        return grid;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> reverseSubmatrix(vector<vector<int>>& grid, int x, int y, int k) {
        int lastRow = x + k - 1;
        int temp;

        for(int i = x; i < lastRow; i++) {
            for(int j = y; j < y + k; j++) {
                temp = grid[i][j];
                grid[i][j] = grid[lastRow][j];
                grid[lastRow][j] = temp;
            }
            lastRow--;
        }

        return grid;
    }
};
```
