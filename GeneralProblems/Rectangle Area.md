Leetcode Question : [Rectangle Area](https://leetcode.com/problems/rectangle-area/)

### Java

```java
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlapHeight = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapWidth = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapHeight * overlapWidth;

        return area1 + area2 - overlapArea;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlapHeight = max(0, min(ax2, bx2) - max(ax1, bx1));
        int overlapWidth = max(0, min(ay2, by2) - max(ay1, by1));
        int overlapArea = overlapHeight * overlapWidth;

        return area1 + area2 - overlapArea;
    }
};
```
