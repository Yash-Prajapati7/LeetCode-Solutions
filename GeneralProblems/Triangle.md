Leetcode Question : [Triangle](https://leetcode.com/problems/triangle)

### Java

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int below = 0, belowRight = 1, current = 0;

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                below = triangle.get(i + 1).get(j);
                belowRight = triangle.get(i + 1).get(j + 1);

                current = triangle.get(i).get(j);

                triangle.get(i).set(j, current + ((below < belowRight) ? below : belowRight ));
            }
        }

        return triangle.get(0).get(0);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 1) {
            return triangle[0][0];
        }

        int below = 0, belowRight = 1, current = 0;

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].size(); j++) {
                below = triangle[i + 1][j];
                belowRight = triangle[i + 1][j + 1];

                current = triangle[i][j];

                triangle[i][j] = current + ((below < belowRight) ? below : belowRight);
            }
        }

        return triangle[0][0];
    }
};
```
