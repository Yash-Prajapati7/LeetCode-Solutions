Leetcode Question : [Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)

### Java

```java
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // inorder to find the closest point we do (value, min, max) => max( min, min(value, max) )
        // where the (value, min, max) will be (xCenter, x1, x2) & (yCenter, y1, y2)

        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        return ((dx * dx) + (dy * dy)) <= (radius * radius);
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // inorder to find the closest point we do (value, min, max) => max( min, min(value, max) )
        // where the (value, min, max) will be (xCenter, x1, x2) & (yCenter, y1, y2)

        int closestX = max(x1, min(xCenter, x2));
        int closestY = max(y1, min(yCenter, y2));

        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        return ((dx * dx) + (dy * dy)) <= (radius * radius);
    }
};
```
