Leetcode Question : [Maximum Number of Points with Cost](https://leetcode.com/problems/maximum-number-of-points-with-cost/)
## Method - 1
### Java
```java
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] prevRow = new long[n];
        
        // Initialize the first row
        for (int i = 0; i < n; i++) {
            prevRow[i] = points[0][i];
        }
        
        // Iterate through each row
        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] currentRow = new long[n];
            
            // Calculate left max for the current row
            leftMax[0] = prevRow[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, prevRow[j]);
            }
            
            // Calculate right max for the current row
            rightMax[n - 1] = prevRow[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, prevRow[j]);
            }
            
            // Calculate the maximum points for the current row
            for (int j = 0; j < n; j++) {
                currentRow[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }
            
            prevRow = currentRow;
        }
        
        // Return the maximum points from the last row
        long maxPoints = 0;
        for (int i = 0; i < n; i++) {
            maxPoints = Math.max(maxPoints, prevRow[i]);
        }
        
        return maxPoints;
    }
}
```

### C++
```cpp
class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int m = points.size();
        int n = points[0].size();
        
        vector<long long> prevRow(n);
        
        // Initialize the first row
        for (int i = 0; i < n; i++) {
            prevRow[i] = points[0][i];
        }
        
        // Iterate through each row
        for (int i = 1; i < m; i++) {
            vector<long long> leftMax(n), rightMax(n), currentRow(n);
            
            // Calculate left max for the current row
            leftMax[0] = prevRow[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = max(leftMax[j - 1] - 1, prevRow[j]);
            }
            
            // Calculate right max for the current row
            rightMax[n - 1] = prevRow[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = max(rightMax[j + 1] - 1, prevRow[j]);
            }
            
            // Calculate the maximum points for the current row
            for (int j = 0; j < n; j++) {
                currentRow[j] = points[i][j] + max(leftMax[j], rightMax[j]);
            }
            
            prevRow = currentRow;
        }
        
        // Return the maximum points from the last row
        long long maxPoints = 0;
        for (int i = 0; i < n; i++) {
            maxPoints = max(maxPoints, prevRow[i]);
        }
        
        return maxPoints;
    }
};
```
## Method- 2 (Optimized)
### Java
```java
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        // Initialize the previous row
        long[] prevRow = new long[n];
        for (int j = 0; j < n; j++) {
            prevRow[j] = points[0][j];
        }
        
        // Iterate through each row starting from the second row
        for (int i = 1; i < m; i++) {
            long[] currentRow = new long[n];
            
            // Calculate the left to right max in the same loop as right to left
            long leftMax = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                leftMax = Math.max(leftMax, prevRow[j] + j);
                currentRow[j] = points[i][j] + leftMax - j;
            }
            
            long rightMax = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                rightMax = Math.max(rightMax, prevRow[j] - j);
                currentRow[j] = Math.max(currentRow[j], points[i][j] + rightMax + j);
            }
            
            prevRow = currentRow;
        }
        
        // Return the maximum points from the last row
        long maxPoints = 0;
        for (long pointsInColumn : prevRow) {
            maxPoints = Math.max(maxPoints, pointsInColumn);
        }
        
        return maxPoints;
    }
}
```

### C++
```cpp
class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int m = points.size();
        int n = points[0].size();
        
        // Initialize the previous row
        vector<long long> prevRow(n);
        for (int j = 0; j < n; j++) {
            prevRow[j] = points[0][j];
        }
        
        // Iterate through each row starting from the second row
        for (int i = 1; i < m; i++) {
            vector<long long> currentRow(n);
            
            // Calculate the left to right max in the same loop as right to left
            long long leftMax = LLONG_MIN;
            for (int j = 0; j < n; j++) {
                leftMax = max(leftMax, prevRow[j] + j);
                currentRow[j] = points[i][j] + leftMax - j;
            }
            
            long long rightMax = LLONG_MIN;
            for (int j = n - 1; j >= 0; j--) {
                rightMax = max(rightMax, prevRow[j] - j);
                currentRow[j] = max(currentRow[j], points[i][j] + rightMax + j);
            }
            
            prevRow = currentRow;
        }
        
        // Return the maximum points from the last row
        long long maxPoints = 0;
        for (long long pointsInColumn : prevRow) {
            maxPoints = max(maxPoints, pointsInColumn);
        }
        
        return maxPoints;
    }
};
```
