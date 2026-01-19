Leetcode Question : [Maximum Side Length of a Square with Sum Less than or Equal to Threshold](https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/)

### Java

```java
class Solution {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                    prefix[i - 1][j] +
                    prefix[i][j - 1] -
                    prefix[i - 1][j - 1] +
                    mat[i - 1][j - 1];
            }
        }

        int left = 1;
        int right = Math.min(m, n);
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) >> 1;
            boolean find = false;

            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    int sum =
                        prefix[i + mid - 1][j + mid - 1] -
                        prefix[i - 1][j + mid - 1] -
                        prefix[i + mid - 1][j - 1] +
                        prefix[i - 1][j - 1];

                    if (sum <= threshold) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }

            if (find) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
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
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> prefix(m + 1, vector<int>(n + 1, 0));

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                    prefix[i - 1][j] +
                    prefix[i][j - 1] -
                    prefix[i - 1][j - 1] +
                    mat[i - 1][j - 1];
            }
        }

        int left = 1;
        int right = min(m, n);
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) >> 1;
            bool find = false;

            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    int sum =
                        prefix[i + mid - 1][j + mid - 1] -
                        prefix[i - 1][j + mid - 1] -
                        prefix[i + mid - 1][j - 1] +
                        prefix[i - 1][j - 1];

                    if (sum <= threshold) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }

            if (find) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
};
```
