Leetcode Question : [Separate Squares I](https://leetcode.com/problems/separate-squares-i)

### Java

```java
class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;

        // Sort by bottom y-coordinate
        Arrays.sort(squares, (a, b) -> a[1] - b[1]);

        double totalArea = 0.0;
        double maxY = 0.0;

        // Compute total area and highest top edge
        for (int[] sq : squares) {
            double side = sq[2];
            totalArea += side * side;
            maxY = Math.max(maxY, sq[1] + side);
        }

        double low = squares[0][1];
        double high = maxY;
        double error = 1e-5;

        while (high - low > error) {
            double mid = (low + high) / 2;
            double currentArea = 0.0;

            for (int i = 0; i < n; i++) {
                int[] sq = squares[i];
                if (sq[1] >= mid) break;

                double h = Math.min(mid - sq[1], sq[2]);
                currentArea += sq[2] * h;
            }

            if (currentArea >= totalArea / 2.0) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double separateSquares(vector<vector<int>>& squares) {
        int n = squares.size();

        sort(squares.begin(), squares.end(),
             [](const vector<int>& a, const vector<int>& b) {
                 return a[1] < b[1];
             });

        double totalArea = 0.0;
        double maxY = 0.0;

        for (auto &sq : squares) {
            double side = sq[2];
            totalArea += side * side;
            maxY = max(maxY, sq[1] + side);
        }

        double low = squares[0][1];
        double high = maxY;
        double error = 1e-5;

        while (high - low > error) {
            double mid = (low + high) / 2.0;
            double currentArea = 0.0;

            for (int i = 0; i < n; i++) {
                if (squares[i][1] >= mid) break;

                double h = min(mid - squares[i][1], (double)squares[i][2]);
                currentArea += squares[i][2] * h;
            }

            if (currentArea >= totalArea / 2.0) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }
};
```
