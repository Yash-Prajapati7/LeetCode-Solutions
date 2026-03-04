Leetcode Question : [Special Positions in a Binary Matrix](https://leetcode.com/problems/special-positions-in-a-binary-matrix/)

### Java

```java
class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        int sum = 0;

        for(int i = 0; i < m; i++) {
            sum = 0;
            for(int j = 0; j < n; j++) {
                sum += mat[i][j];
                if(sum > 1) {
                    row[i] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = 0; j < m; j++) {
                sum += mat[j][i];
                if(sum > 1) {
                    col[i] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1 && !row[i] && !col[j]) {
                    result++;
                }
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
    int numSpecial(vector<vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size();
        vector<bool> row(m);
        vector<bool> col(n);
        int sum = 0;

        for(int i = 0; i < m; i++) {
            sum = 0;
            for(int j = 0; j < n; j++) {
                sum += mat[i][j];
                if(sum > 1) {
                    row[i] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = 0; j < m; j++) {
                sum += mat[j][i];
                if(sum > 1) {
                    col[i] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1 && !row[i] && !col[j]) {
                    result++;
                }
            }
        }

        return result;
    }
};
```
