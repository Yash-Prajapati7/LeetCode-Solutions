Leetcode Question : [Flood Fill](https://leetcode.com/problems/flood-fill/)

### Java

```java
class Solution {
    private void helper(int[][] image, int sr, int sc, int color, int initial) {
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) return;
        if(image[sr][sc] == initial) {
            image[sr][sc] = color;
            helper(image, sr + 1, sc, color, initial);
            helper(image, sr, sc + 1, color, initial);
            helper(image, sr - 1, sc, color, initial);
            helper(image, sr, sc - 1, color, initial);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if(initial == color) return image; // prevent infinite recursion
        helper(image, sr, sc, color, initial);
        return image;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    void helper(vector<vector<int>>& image, int sr, int sc, int color, int initial) {
        if(sr >= image.size() || sr < 0 || sc >= image[0].size() || sc < 0) return;
        if(image[sr][sc] == initial) {
            image[sr][sc] = color;
            helper(image, sr + 1, sc, color, initial);
            helper(image, sr, sc + 1, color, initial);
            helper(image, sr - 1, sc, color, initial);
            helper(image, sr, sc - 1, color, initial);
        }
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if(initial == color) return image; // prevent infinite recursion
        helper(image, sr, sc, color, initial);
        return image;
    }
};
```
