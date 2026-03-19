Leetcode Question : [Count Submatrices With Equal Frequency of X and Y](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)

---

### Java

```java
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int result = 0;
        int[] sumX = new int[cols];
        int[] sumY = new int[cols];

        for(int i = 0; i < rows; i++) {
            int x = 0, y = 0;
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 'X') x++;
                else if(grid[i][j] == 'Y') y++;

                sumX[j] += x;
                sumY[j] += y;

                if(sumX[j] > 0 && sumX[j] == sumY[j]) result++;
            }
        }

        return result;
    }
}
```

---

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numberOfSubmatrices(vector<vector<char>>& grid) {
        int rows = grid.size(), cols = grid[0].size();
        int result = 0;
        vector<int> sumX(cols, 0);
        vector<int> sumY(cols, 0);

        for(int i = 0; i < rows; i++) {
            int x = 0, y = 0;
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 'X') x++;
                else if(grid[i][j] == 'Y') y++;

                sumX[j] += x;
                sumY[j] += y;

                if(sumX[j] > 0 && sumX[j] == sumY[j]) result++;
            }
        }

        return result;
    }
};
```

