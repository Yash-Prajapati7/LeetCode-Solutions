Leetcode Question : [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/description/)

### Java
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
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
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int top = 0, bottom = matrix.size() - 1, left = 0, right = matrix[0].size() - 1;
        vector<int> ans;
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ans.push_back(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                ans.push_back(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.push_back(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans.push_back(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
};
```
