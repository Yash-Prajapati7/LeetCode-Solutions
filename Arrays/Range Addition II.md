Leetcode Question : [Range Addition II](https://leetcode.com/problems/range-addition-ii/)

### Java

```java
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m * n;
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        for(int[] rows : ops) {
            minRow = rows[0] < minRow ? rows[0] : minRow;
            minCol = rows[1] < minCol ? rows[1] : minCol;
        }

        return minRow * minCol;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        if(ops.size() == 0) return m * n;
        int minRow = INT_MAX, minCol = INT_MAX;
        for(auto& rows : ops) {
            minRow = rows[0] < minRow ? rows[0] : minRow;
            minCol = rows[1] < minCol ? rows[1] : minCol;
        }

        return minRow * minCol;
    }
};
```
