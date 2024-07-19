Leetcode Question : https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
### Java
```java
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            int columnIndex = 0;

            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    columnIndex = j;
                }
            }

            boolean isMax = true;
            for(int k = 0; k < rows; k++) {
                if(matrix[k][columnIndex] > minVal) {
                    isMax = false;
                    break;
                }
            }

            if(isMax) {
                result.add(matrix[i][columnIndex]);
            }
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
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> result;
        int rows = matrix.size();
        int cols = matrix[0].size();

        for (int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            int minIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minIndex = j;
                }
            }

            bool isMax = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minIndex] > minVal) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                result.push_back(minVal);
            }
        }

        return result;
    }
};
```
