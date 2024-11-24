Leetcode Question: [Maximum Matrix Sum](https://leetcode.com/problems/maximum-matrix-sum/)

### Java
```java
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumAbs = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;
        
        for (int[] row : matrix) {
            for (int num : row) {
                // Count the number of negative numbers
                if (num < 0) {
                    num = -num;
                    negCount++;
                }
                
                sumAbs += num;
                // Track the minimum absolute value
                minAbs = minAbs < num ? minAbs : num;
            }
        }
        
        // Adjust the sum if the count of negatives is odd
        if (negCount % 2 != 0) {
            sumAbs -= (minAbs << 1);
        }
        
        return sumAbs;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        long long sumAbs = 0;
        int negCount = 0;
        int minAbs = INT_MAX;
        
        for (const auto& row : matrix) {
            for (int num : row) {
                // Count the number of negative numbers
                if (num < 0) {
                    num = -num;
                    negCount++;
                }
                
                sumAbs += num;
                // Track the minimum absolute value
                minAbs = min(minAbs, num);
            }
        }
        
        // Adjust the sum if the count of negatives is odd
        if (negCount % 2 != 0) {
            sumAbs -= (minAbs << 1);
        }
        
        return sumAbs;
    }
};
```
