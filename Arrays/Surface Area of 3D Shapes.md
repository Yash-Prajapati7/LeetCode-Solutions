Leetcode Question : [Surface Area of 3D Shapes](https://leetcode.com/problems/surface-area-of-3d-shapes/)

### Java

```java
class Solution {
    public int surfaceArea(int[][] grid) {
        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};

        int size = grid.length;
        int surfaceArea = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int height = grid[row][col];

                if (height > 0) {
                    surfaceArea += 2;

                    for (int dir = 0; dir < 4; dir++) {
                        int newRow = row + rowOffset[dir];
                        int newCol = col + colOffset[dir];

                        int neighborHeight = 0;
                        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                            neighborHeight = grid[newRow][newCol];
                        }

                        surfaceArea += Math.max(height - neighborHeight, 0);
                    }
                }
            }
        }

        return surfaceArea;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
        vector<int> rowOffset = {0, 1, 0, -1};
        vector<int> colOffset = {1, 0, -1, 0};

        int size = grid.size();
        int surfaceArea = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int height = grid[row][col];

                if (height > 0) {
                    surfaceArea += 2;

                    for (int dir = 0; dir < 4; dir++) {
                        int newRow = row + rowOffset[dir];
                        int newCol = col + colOffset[dir];

                        int neighborHeight = 0;
                        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                            neighborHeight = grid[newRow][newCol];
                        }

                        surfaceArea += max(height - neighborHeight, 0);
                    }
                }
            }
        }

        return surfaceArea;
    }
};
```
