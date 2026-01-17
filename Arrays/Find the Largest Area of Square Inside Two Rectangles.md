Leetcode Question : [Find the Largest Area of Square Inside Two Rectangles](https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/)

### Java

```java
class Solution {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int minX = (topRight[i][0] < topRight[j][0]) ? topRight[i][0] : topRight[j][0];
                int maxX = (bottomLeft[i][0] > bottomLeft[j][0]) ? bottomLeft[i][0] : bottomLeft[j][0];
                int w = minX - maxX;

                int minY = (topRight[i][1] < topRight[j][1]) ? topRight[i][1] : topRight[j][1];
                int maxY = (bottomLeft[i][1] > bottomLeft[j][1]) ? bottomLeft[i][1] : bottomLeft[j][1];
                int h = minY - maxY;

                int side = (w < h) ? w : h;

                maxSide = (maxSide > side) ? maxSide : side;
            }
        }

        return maxSide * maxSide;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long largestSquareArea(vector<vector<int>>& bottomLeft, vector<vector<int>>& topRight) {
        int n = (int)bottomLeft.size();
        long long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int minX = (topRight[i][0] < topRight[j][0]) ? topRight[i][0] : topRight[j][0];
                int maxX = (bottomLeft[i][0] > bottomLeft[j][0]) ? bottomLeft[i][0] : bottomLeft[j][0];
                int w = minX - maxX;

                int minY = (topRight[i][1] < topRight[j][1]) ? topRight[i][1] : topRight[j][1];
                int maxY = (bottomLeft[i][1] > bottomLeft[j][1]) ? bottomLeft[i][1] : bottomLeft[j][1];
                int h = minY - maxY;

                int side = (w < h) ? w : h;

                maxSide = (maxSide > side) ? maxSide : side;
            }
        }

        return maxSide * maxSide;
    }
};
```
