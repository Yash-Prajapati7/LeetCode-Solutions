## Leetcode Question : [Minimize Manhattan Distances](https://leetcode.com/problems/minimize-manhattan-distances/description/)


### Java
```java
class Solution {
    // find manhattan distance between two points
    private int manhattanDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    // find max manhattan distance in a given array of points after removing indexToRemove point
    private int[] maxManhattanDistance(int[][] points, int indexToRemove) {
        int n = points.length;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int maxSumIndex = -1, minSumIndex = -1, maxDiffIndex = -1, minDiffIndex = -1;

        for (int i = 0; i < n; i++) {
            if (i != indexToRemove) {  // check for point to remove
                int sum = points[i][0] + points[i][1];
                int diff = points[i][0] - points[i][1];

                if (sum > maxSum) {
                    maxSumIndex = i;
                    maxSum = sum;
                }
                if (sum < minSum) {
                    minSumIndex = i;
                    minSum = sum;
                }
                if (diff > maxDiff) {
                    maxDiffIndex = i;
                    maxDiff = diff;
                }
                if (diff < minDiff) {
                    minDiffIndex = i;
                    minDiff = diff;
                }
            }
        }

        if ((maxSum - minSum) >= (maxDiff - minDiff)) {
            return new int[]{maxSumIndex, minSumIndex};
        }
        return new int[]{maxDiffIndex, minDiffIndex};
    }

    public int minimumDistance(int[][] points) {
        int[] maxPair = maxManhattanDistance(points, -1);
        int mi = maxPair[0];
        int mj = maxPair[1];

        int[] maxPair1 = maxManhattanDistance(points, mi); // remove mi
        int mi1 = maxPair1[0];
        int mj1 = maxPair1[1];

        int[] maxPair2 = maxManhattanDistance(points, mj); // remove mj
        int mi2 = maxPair2[0];
        int mj2 = maxPair2[1];

        return Math.min(manhattanDistance(points, mi1, mj1),
                        manhattanDistance(points, mi2, mj2));
    }
}
```

### C++
```cpp
#include <vector>
#include <cmath>
#include <algorithm>
#include <limits.h>

using namespace std;

class Solution {
private:
    // find manhattan distance between two points
    int manhattanDistance(vector<vector<int>>& points, int i, int j) {
        return abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
    }

    // find max manhattan distance in a given array of points after removing indexToRemove point
    pair<int, int> maxManhattanDistance(vector<vector<int>>& points, int indexToRemove) {
        int n = points.size();
        int maxSum = INT_MIN;
        int minSum = INT_MAX;
        int maxDiff = INT_MIN;
        int minDiff = INT_MAX;
        int maxSumIndex = -1, minSumIndex = -1, maxDiffIndex = -1, minDiffIndex = -1;

        for (int i = 0; i < n; i++) {
            if (i != indexToRemove) {  // check for point to remove
                int sum = points[i][0] + points[i][1];
                int diff = points[i][0] - points[i][1];

                if (sum > maxSum) {
                    maxSumIndex = i;
                    maxSum = sum;
                }
                if (sum < minSum) {
                    minSumIndex = i;
                    minSum = sum;
                }
                if (diff > maxDiff) {
                    maxDiffIndex = i;
                    maxDiff = diff;
                }
                if (diff < minDiff) {
                    minDiffIndex = i;
                    minDiff = diff;
                }
            }
        }

        if ((maxSum - minSum) >= (maxDiff - minDiff)) {
            return {maxSumIndex, minSumIndex};
        }
        return {maxDiffIndex, minDiffIndex};
    }

public:
    int minimumDistance(vector<vector<int>>& points) {
        auto maxPair = maxManhattanDistance(points, -1);
        int mi = maxPair.first;
        int mj = maxPair.second;

        auto maxPair1 = maxManhattanDistance(points, mi); // remove mi
        int mi1 = maxPair1.first;
        int mj1 = maxPair1.second;

        auto maxPair2 = maxManhattanDistance(points, mj); // remove mj
        int mi2 = maxPair2.first;
        int mj2 = maxPair2.second;

        return min(manhattanDistance(points, mi1, mj1),
                   manhattanDistance(points, mi2, mj2));
    }
};
```
