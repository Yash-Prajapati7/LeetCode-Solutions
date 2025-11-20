Leetcode Question : [Set Intersection Size At Least Two](https://leetcode.com/problems/set-intersection-size-at-least-two/)

### Java

```java
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int[] prev = new int[2];
        prev[0] = intervals[0][1];
        prev[1] = intervals[0][1] - 1;

        int ans = 2;

        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];

            int elementsAdded = 0;

            for (int index = 0; index < 2; index++) {
                // check if the chosen index is in range [s, e]
                if (!(prev[index] >= s && prev[index] <= e)) {
                    prev[index] = e - elementsAdded;
                    elementsAdded++;
                }
            }

            ans += elementsAdded;
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int intersectionSizeTwo(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        vector<int> prev(2);
        prev[0] = intervals[0][1];
        prev[1] = intervals[0][1] - 1;

        int ans = 2;

        for (auto& interval : intervals) {
            int s = interval[0];
            int e = interval[1];

            int elementsAdded = 0;

            for (int index = 0; index < 2; index++) {
                if (!(prev[index] >= s && prev[index] <= e)) {
                    prev[index] = e - elementsAdded;
                    elementsAdded++;
                }
            }

            ans += elementsAdded;
        }

        return ans;
    }
};
```
