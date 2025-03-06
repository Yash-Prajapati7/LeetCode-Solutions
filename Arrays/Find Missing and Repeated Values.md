Leetcode Question : [Find Missing and Repeated Values](https://leetcode.com/problems/find-missing-and-repeated-values/)

### Java
```java
class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum = 0, sqrSum = 0;
        long n = grid.length;
        long total = n * n;
        long val = 0;

        // Calculate actual sum and squared sum from grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                val = grid[i][j];
                sum += val;
                sqrSum += val * val;
            }
        }

        // Calculate differences from expected sums
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long sumDiff = sum - (total * (total + 1)) / 2;
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        long divison = (sqrDiff / sumDiff);
        int repeat = (int)(divison + sumDiff) / 2;
        int missing = (int)(divison - sumDiff) / 2;

        return new int[] { repeat, missing };
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        long long sum = 0, sqrSum = 0;
        long long n = grid.size();
        long long total = n * n;
        long long val = 0;

        // Calculate actual sum and squared sum from grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                val = grid[i][j];
                sum += val;
                sqrSum += val * val;
            }
        }

        // Calculate differences from expected sums
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long long sumDiff = sum - (total * (total + 1)) / 2;
        long long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        long long division = (sqrDiff / sumDiff);
        int repeat = (division + sumDiff) / 2;
        int missing = (division - sumDiff) / 2;

        return { repeat, missing };
    }
};
```
