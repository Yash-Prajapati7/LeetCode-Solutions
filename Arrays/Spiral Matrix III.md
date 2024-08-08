Leetcode Question : [Spiral Matrix III](https://leetcode.com/problems/spiral-matrix-iii/description/)
### Java
```java
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        int steps = 1;
        int dir = 0;
        int[] direction = {0, 1, 0, -1, 0};  // right, down, left, up
        result[index++] = new int[] { rStart, cStart };

        while(index < rows * cols) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < steps; j++) {
                    rStart += direction[dir];
                    cStart += direction[dir + 1];

                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[] { rStart, cStart };
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        return result;
    }
}
```

### C++
```cpp
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        vector<vector<int>> result(rows * cols, vector<int>(2));
        int index = 0;
        int steps = 1;
        int dir = 0;
        int direction[5] = {0, 1, 0, -1, 0};  // right, down, left, up
        result[index++] = { rStart, cStart };

        while(index < rows * cols) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < steps; j++) {
                    rStart += direction[dir];
                    cStart += direction[dir + 1];

                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = { rStart, cStart };
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        return result;
    }
};
```
