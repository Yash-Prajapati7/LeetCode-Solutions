Leetcode Question : [Rotating the Box](https://leetcode.com/problems/rotating-the-box/)

### Java
```java
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Let the stones fall to the right due to gravity
        for (int i = 0; i < m; i++) {
            int emptyPos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyPos = j - 1; // Reset the empty position to one before the obstacle
                } else if (box[i][j] == '#') {
                    // Swap stone '#' with the empty position
                    box[i][j] = '.';
                    box[i][emptyPos] = '#';
                    emptyPos--;
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        char[][] rotated = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = box[m - j - 1][i];
            }
        }

        return rotated;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        int m = box.size();
        int n = box[0].size();

        // Let the stones fall to the right due to gravity
        for (int i = 0; i < m; i++) {
            int emptyPos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyPos = j - 1; // Reset the empty position to one before the obstacle
                } else if (box[i][j] == '#') {
                    // Swap stone '#' with the empty position
                    box[i][j] = '.';
                    box[i][emptyPos] = '#';
                    emptyPos--;
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        vector<vector<char>> rotated(n, vector<char>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = box[m - j - 1][i];
            }
        }

        return rotated;
    }
};
```
