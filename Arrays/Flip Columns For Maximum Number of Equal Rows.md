Leetcode Question : [Flip Columns For Maximum Number of Equal Rows](https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows)

### Java
```java
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> pattern = new HashMap<>();
        int cols = matrix[0].length;

        for(int[] current : matrix) {
            StringBuilder rowPattern = new StringBuilder(cols);
            for(int col = 0; col < cols; col++) {
                if(current[0] == current[col]) {
                    rowPattern.append("T");
                }
                else {
                    rowPattern.append("F");
                }
            }

            String row = rowPattern.toString();
            pattern.put(row, pattern.getOrDefault(row, 0) + 1);
        }

        int maxFreq = 0;
        for(int freq : pattern.values()) {
            maxFreq = Math.max(freq, maxFreq);
        }

        return maxFreq;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        unordered_map<string, int> pattern;
        int cols = matrix[0].size();

        for(const auto& current : matrix) {
            string rowPattern;
            for(int col = 0; col < cols; col++) {
                if(current[0] == current[col]) {
                    rowPattern += "T";
                }
                else {
                    rowPattern += "F";
                }
            }

            pattern[rowPattern]++;
        }

        int maxFreq = 0;
        for(const auto& [key, freq] : pattern) {
            maxFreq = max(freq, maxFreq);
        }

        return maxFreq;
    }
};
```
