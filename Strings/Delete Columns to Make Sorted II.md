Leetcode Question : [Delete Columns to Make Sorted II](https://leetcode.com/problems/delete-columns-to-make-sorted-ii)

### Java

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int totalRows = strs.length;
        int totalCols = strs[0].length();
        int deletedCols = 0;
        boolean[] isRowPairSorted = new boolean[totalRows];
        boolean deletedColumn = false;

        for (int col = 0; col < totalCols; col++) {
            deletedColumn = false;
            for (int row = 0; row < totalRows - 1; row++) {
                if (!isRowPairSorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    deletedCols++;
                    deletedColumn = true;
                    break;
                }
            }

            if (deletedColumn) {
                continue;
            }

            for (int row = 0; row < totalRows - 1; row++) {
                if (strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    isRowPairSorted[row] = true;
                }
            }
        }

        return deletedCols;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int totalRows = strs.size();
        int totalCols = strs[0].size();
        int deletedCols = 0;
        vector<bool> isRowPairSorted(totalRows - 1, false);

        for (int col = 0; col < totalCols; col++) {
            bool deleteColumn = false;

            for (int row = 0; row < totalRows - 1; row++) {
                if (!isRowPairSorted[row] &&
                    strs[row][col] > strs[row + 1][col]) {
                    deletedCols++;
                    deleteColumn = true;
                    break;
                }
            }

            if (deleteColumn) continue;

            for (int row = 0; row < totalRows - 1; row++) {
                if (strs[row][col] < strs[row + 1][col]) {
                    isRowPairSorted[row] = true;
                }
            }
        }

        return deletedCols;
    }
};
```
