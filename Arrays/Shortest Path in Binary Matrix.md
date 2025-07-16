Leetcode Question : [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

### Java

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }
        
        int[][] dir = {
                { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 },
                { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] currentDirection = q.poll();
            int x = currentDirection[0];
            int y = currentDirection[1];
            int distance = grid[x][y];

            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    grid[newX][newY] = distance + 1;
                    q.offer(new int[] { newX, newY });
                }
            }

        }
        return grid[n - 1][n - 1] != 0 ? grid[n - 1][n - 1] : -1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        vector<vector<int>> dir = {
            {1, 0}, {1, 1}, {0, 1}, {-1, 1},
            {-1, 0}, {-1, -1}, {0, -1}, {1, -1}
        };

        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;

        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            int distance = grid[x][y];

            for (auto& d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    grid[newX][newY] = distance + 1;
                    q.push({newX, newY});
                }
            }
        }

        return grid[n - 1][n - 1] != 0 ? grid[n - 1][n - 1] : -1;
    }
};
```
