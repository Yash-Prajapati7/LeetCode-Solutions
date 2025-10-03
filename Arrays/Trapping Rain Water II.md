Leetcode Question : [Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii)

### Java

```java
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int result = 0;
        int m = heightMap.length, n = heightMap[0].length;
        if(m < 3 || n < 3) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];

        // Populate the priority queue with initial boundaries
        for(int i = 0; i < m; i++) {
            pq.offer(new int[] { heightMap[i][0], i, 0 });
            pq.offer(new int[] { heightMap[i][n - 1], i, n - 1 });
            visited[i][0] = visited[i][n - 1] = true;
        }

        for(int j = 1; j < n - 1; j++) {
            pq.offer(new int[] { heightMap[0][j], 0, j });
            pq.offer(new int[] { heightMap[m - 1][j], m - 1, j });
            visited[0][j] = visited[m - 1][j] = true;
        }

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while(!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0], x = cell[1], y = cell[2];

            for(int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if(nx > 0 && ny > 0 && nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    int currentHeight = height - heightMap[nx][ny];
                    result += ( currentHeight < 0 ? 0 : currentHeight );

                    int maxHeight = height > heightMap[nx][ny] ? height : heightMap[nx][ny];
                    pq.offer(new int[] { maxHeight, nx, ny });
                }
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        int result = 0;
        int m = heightMap.size(), n = heightMap[0].size();
        if(m < 3 || n < 3) {
            return 0;
        }

        auto cmp = [](const array<int,3>& a, const array<int,3>& b) {
            return a[0] > b[0];
        };
        priority_queue<array<int,3>, vector<array<int,3>>, decltype(cmp)> pq(cmp);

        vector<vector<bool>> visited(m, vector<bool>(n, false));

        // Populate the priority queue with initial boundaries
        for(int i = 0; i < m; i++) {
            pq.push({ heightMap[i][0], i, 0 });
            pq.push({ heightMap[i][n - 1], i, n - 1 });
            visited[i][0] = visited[i][n - 1] = true;
        }

        for(int j = 1; j < n - 1; j++) {
            pq.push({ heightMap[0][j], 0, j });
            pq.push({ heightMap[m - 1][j], m - 1, j });
            visited[0][j] = visited[m - 1][j] = true;
        }

        vector<pair<int,int>> dirs = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        while(!pq.empty()) {
            auto cell = pq.top(); pq.pop();
            int height = cell[0], x = cell[1], y = cell[2];

            for(auto& d : dirs) {
                int nx = x + d.first, ny = y + d.second;
                if(nx > 0 && ny > 0 && nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    int currentHeight = height - heightMap[nx][ny];
                    result += ( currentHeight < 0 ? 0 : currentHeight );

                    int maxHeight = max(height, heightMap[nx][ny]);
                    pq.push({ maxHeight, nx, ny });
                }
            }
        }

        return result;
    }
};
```
