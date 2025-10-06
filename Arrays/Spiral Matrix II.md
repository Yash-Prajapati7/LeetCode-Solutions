Leetcode Question : [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)

### Java

```java
class Solution {
    private void print(int[][] m) {
        System.out.println();
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int i = 1;
        int row = 0, col = 0;
        int topRowLimit = 0, bottomRowLimit = n - 1, leftColLimit = 0, rightColLimit = n - 1;

        while(i <= (n * n)) {
            while(col <= rightColLimit) {
                matrix[row][col++] = i++;
            }
            col = rightColLimit;
            topRowLimit++;
            row++;

            while(row <= bottomRowLimit) {
                matrix[row++][col] = i++;
            }
            row = bottomRowLimit;
            rightColLimit--;
            col--;

            while(col > leftColLimit) {
                matrix[row][col--] = i++;
            }
            col = leftColLimit;
            bottomRowLimit--;

            while(row > topRowLimit) {
                matrix[row--][col] = i++;
            }
            row = topRowLimit;
            leftColLimit++;
        }

        return matrix;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    void print(vector<vector<int>>& m) {
        cout << endl;
        for(int i = 0; i < m.size(); i++) {
            for(int j = 0; j < m[0].size(); j++) {
                cout << m[i][j] << "  ";
            }
            cout << endl;
        }
    }

public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> matrix(n, vector<int>(n, 0));

        int i = 1;
        int row = 0, col = 0;
        int topRowLimit = 0, bottomRowLimit = n - 1, leftColLimit = 0, rightColLimit = n - 1;

        while(i <= (n * n)) {
            while(col <= rightColLimit) {
                matrix[row][col++] = i++;
            }
            col = rightColLimit;
            topRowLimit++;
            row++;

            while(row <= bottomRowLimit) {
                matrix[row++][col] = i++;
            }
            row = bottomRowLimit;
            rightColLimit--;
            col--;

            while(col > leftColLimit) {
                matrix[row][col--] = i++;
            }
            col = leftColLimit;
            bottomRowLimit--;

            while(row > topRowLimit) {
                matrix[row--][col] = i++;
            }
            row = topRowLimit;
            leftColLimit++;
        }

        return matrix;
    }
};
```
