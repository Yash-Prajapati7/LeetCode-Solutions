Leetcode Question : [Count Submatrices With Top-Left Element and Sum Less Than K](https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/)

### Java

```java
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        int[] cols = new int[col];
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < row; i++) {
            sum = 0;
            for (int j = 0; j < col; j++) {
                cols[j] += grid[i][j];  
                sum += cols[j];
                if(sum <= k) {
                    ans++;
                }              
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
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int row = grid.size(), col = grid[0].size();
        vector<int> cols(col, 0);
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < row; i++) {
            sum = 0;
            for (int j = 0; j < col; j++) {
                cols[j] += grid[i][j];
                sum += cols[j];
                if (sum <= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
};
```
