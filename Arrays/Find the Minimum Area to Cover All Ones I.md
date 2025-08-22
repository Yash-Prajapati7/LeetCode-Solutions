Leetcode Question : [Find the Minimum Area to Cover All Ones I](https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i)

### Java

```java
class Solution {
    public int minimumArea(int[][] grid) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = -1, max2 = -1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    min1 = min1 < i ? min1 : i;
                    min2 = min2 < j ? min2 : j;
                    max1 = max1 < i ? i : max1;
                    max2 = max2 < j ? j : max2;
                }
            }
        }

        return (max1 - min1 + 1) * (max2 - min2 + 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumArea(vector<vector<int>>& grid) {
        int min1 = INT_MAX, min2 = INT_MAX, max1 = -1, max2 = -1;

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 1) {
                    min1 = min(min1, i);
                    min2 = min(min2, j);
                    max1 = max(max1, i);
                    max2 = max(max2, j);
                }
            }
        }

        return (max1 - min1 + 1) * (max2 - min2 + 1);
    }
};
```
