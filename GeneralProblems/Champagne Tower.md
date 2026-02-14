Leetcode Question : [Champagne Tower](https://leetcode.com/problems/champagne-tower/)

### Java

```java
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] filled = new double[102][102];
        double quantity = 0.0;
        filled[0][0] = poured;  // base case

        for(int row = 0; row <= query_row; row++) {
            for(int col = 0; col <= row; col++) {
                quantity = (filled[row][col] - 1) / 2.0;
                if(quantity > 0) {
                    filled[row + 1][col] += quantity;
                    filled[row + 1][col + 1] += quantity;
                }
            }
        }

        return Math.min(1, filled[query_row][query_glass]);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        double filled[102][102] = {0};
        double quantity = 0.0;
        filled[0][0] = poured;  // base case

        for(int row = 0; row <= query_row; row++) {
            for(int col = 0; col <= row; col++) {
                quantity = (filled[row][col] - 1) / 2.0;
                if(quantity > 0) {
                    filled[row + 1][col] += quantity;
                    filled[row + 1][col + 1] += quantity;
                }
            }
        }

        return min(1.0, filled[query_row][query_glass]);
    }
};
```
