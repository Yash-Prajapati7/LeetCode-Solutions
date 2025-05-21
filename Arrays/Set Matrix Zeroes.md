Leetcode Question : [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

## Method - 1

### Java

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        // Queues that will store the row and columns of zeros located
        Queue<Integer> rowLocation = new LinkedList<>();
        Queue<Integer> colLocation = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;

        // Boolean arrays to check whether that row or col has already appeared before
        // to reduce the redundancy
        boolean[] rowVisited = new boolean[m];
        boolean[] colVisited = new boolean[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(!rowVisited[i]) {
                        rowLocation.offer(i);
                        rowVisited[i] = true;
                    }
                    if(!colVisited[j]) {
                        colLocation.offer(j);
                        colVisited[j] = true;
                    }
                }
            }
        }

        // Mark all the rows and columns with zero
        while(!rowLocation.isEmpty()) {
            int r = rowLocation.poll();
            for(int i = 0; i < n; i++) {
                matrix[r][i] = 0;
            }
        }

        while(!colLocation.isEmpty()) {
            int c = colLocation.poll();
            for(int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        queue<int> rowLocation;
        queue<int> colLocation;
        int m = matrix.size(), n = matrix[0].size();

        vector<bool> rowVisited(m, false);
        vector<bool> colVisited(n, false);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(!rowVisited[i]) {
                        rowLocation.push(i);
                        rowVisited[i] = true;
                    }
                    if(!colVisited[j]) {
                        colLocation.push(j);
                        colVisited[j] = true;
                    }
                }
            }
        }

        while(!rowLocation.empty()) {
            int r = rowLocation.front();
            rowLocation.pop();
            for(int i = 0; i < n; i++) {
                matrix[r][i] = 0;
            }
        }

        while(!colLocation.empty()) {
            int c = colLocation.front();
            colLocation.pop();
            for(int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    }
};
```

## Method - 2

### Java

```java
public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has any 0
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any 0
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and column to mark zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out cells based on marks
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out first row if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out first column if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        bool firstRowZero = false, firstColZero = false;

        for(int j = 0; j < cols; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for(int i = 0; i < rows; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero) {
            for(int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if(firstColZero) {
            for(int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
};
```
