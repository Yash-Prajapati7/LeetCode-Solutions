LeetCode Question: [Grid Game](https://leetcode.com/problems/grid-game/)

### Java
```java
class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for (int points : grid[0]) {
            firstRowSum += points;
        }

        long secondRowSum = 0, minSum = Long.MAX_VALUE, maxRowSum = Long.MIN_VALUE;

        for (int turningIndex = 0; turningIndex < grid[0].length; turningIndex++) {
            firstRowSum -= grid[0][turningIndex];
            maxRowSum = firstRowSum > secondRowSum ? firstRowSum : secondRowSum;
            minSum = minSum > maxRowSum ? maxRowSum : minSum;
            secondRowSum += grid[1][turningIndex];
        }

        return minSum;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        long long firstRowSum = 0;
        for (int points : grid[0]) {
            firstRowSum += points;
        }

        long long secondRowSum = 0, minSum = LLONG_MAX, maxRowSum = LLONG_MIN;

        for (int turningIndex = 0; turningIndex < grid[0].size(); turningIndex++) {
            firstRowSum -= grid[0][turningIndex];
            maxRowSum = max(firstRowSum, secondRowSum);
            minSum = min(minSum, maxRowSum);
            secondRowSum += grid[1][turningIndex];
        }

        return minSum;
    }
};
```
