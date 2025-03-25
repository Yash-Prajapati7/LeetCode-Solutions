Leetcode Question : [Check If Grid Can Be Cut Into Sections](https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/)

### Java
```java
class Solution {
    // dimension : 0 - for 'x' & 1 - for 'y'
    private boolean checkCuts(int[][] rects, int dimension) {
        int gap = 0;
        Arrays.sort(rects, (a, b) -> a[dimension] - b[dimension]);

        int end = rects[0][dimension + 2];
        for(int i = 1; i < rects.length; i++) {
            int[] rect = rects[i];
            if(end <= rect[dimension]) gap++;
            end = end < rect[dimension + 2] ? rect[dimension + 2] : end;
        }

        return gap >= 2;
    }
    
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    // dimension : 0 - for 'x' & 1 - for 'y'
    bool checkCuts(vector<vector<int>>& rects, int dimension) {
        int gap = 0;
        sort(rects.begin(), rects.end(), [&](const vector<int>& a, const vector<int>& b) {
            return a[dimension] < b[dimension];
        });

        int end = rects[0][dimension + 2];
        for(int i = 1; i < rects.size(); i++) {
            vector<int>& rect = rects[i];
            if(end <= rect[dimension]) gap++;
            end = min(end, rect[dimension + 2]) ? rect[dimension + 2] : end;
        }

        return gap >= 2;
    }

public:
    bool checkValidCuts(int n, vector<vector<int>>& rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
};
```
