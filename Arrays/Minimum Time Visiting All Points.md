Leetcode Question : [Minimum Time Visiting All Points](https://leetcode.com/problems/minimum-time-visiting-all-points/)

### Java

```java
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x1, x2, y1, y2;
        int ans = 0;

        for(int i = 0; i < points.length - 1; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            x2 = points[i + 1][0];
            y2 = points[i + 1][1];
            ans += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));            
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
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int x1, x2, y1, y2;
        int ans = 0;

        for(int i = 0; i < points.size() - 1; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            x2 = points[i + 1][0];
            y2 = points[i + 1][1];
            ans += max(abs(x1 - x2), abs(y1 - y2));
        }

        return ans;
    }
};
```
