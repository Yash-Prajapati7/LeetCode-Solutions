Leetcode Question : [Increment Submatrices by one](https://leetcode.com/problems/increment-submatrices-by-one)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    mat[i][j]++;
                }
            }
        }

        return mat;
    }
}
```

### C++ (TLE)

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> mat(n, vector<int>(n, 0));

        for (auto &q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    mat[i][j]++;
                }
            }
        }

        return mat;
    }
};
```

## Method - 2 (Prefix sum on matrix)

### Java

```java
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int row1 = q[0], row2 = q[2], col1 = q[1], col2 = q[3];

            for (int i = row1; i <= row2; i++) {
                mat[i][col1]++;
                mat[i][col2 + 1]--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = mat[i][j];
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
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> mat(n + 1, vector<int>(n + 1, 0));

        for (auto &q : queries) {
            int row1 = q[0], row2 = q[2], col1 = q[1], col2 = q[3];

            for (int i = row1; i <= row2; i++) {
                mat[i][col1]++;
                mat[i][col2 + 1]--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        mat.pop_back();
        for (auto &row : mat) row.pop_back();

        return mat;
    }
};
```
