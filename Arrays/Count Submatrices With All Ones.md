Leetcode Question : [Count Submatrices With All Ones](https://leetcode.com/problems/count-submatrices-with-all-ones)

### Java

```java
class Solution {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    nums[i][j] = mat[i][j];
                } else {
                    nums[i][j] = mat[i][j] == 0 ? 0 : nums[i][j - 1] + 1;
                }

                int cur = nums[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = Math.min(cur, nums[k][j]);
                    if (cur == 0) {
                        break;
                    }
                    res += cur;
                }
            }
        }

        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        vector<vector<int>> nums(m, vector<int>(n, 0));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    nums[i][j] = mat[i][j];
                } else {
                    nums[i][j] = mat[i][j] == 0 ? 0 : nums[i][j - 1] + 1;
                }

                int cur = nums[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = min(cur, nums[k][j]);
                    if (cur == 0) {
                        break;
                    }
                    res += cur;
                }
            }
        }

        return res;
    }
};
```
