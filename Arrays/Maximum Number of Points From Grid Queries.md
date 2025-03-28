Leetcode Question : [Maximum Number of Points From Grid Queries](https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/)

### Method - 1 [BFS for each query] (Brute Force - TLE)

#### Java
```java
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int[] ans = new int[k];
        int rows = grid.length, cols = grid[0].length;
        int points = 0;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int queryIdx = 0; queryIdx < k; queryIdx++) {
            int qVal = queries[queryIdx];
            Queue<int[]> bfsQueue = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];

            bfsQueue.offer(new int[] { 0, 0 });
            visited[0][0] = true;
            points = 0;

            while (!bfsQueue.isEmpty()) {
                int qSize = bfsQueue.size();
                for (int i = 0; i < qSize; i++) {
                    int[] current = bfsQueue.poll();
                    int currentRow = current[0];
                    int currentCol = current[1];

                    if (grid[currentRow][currentCol] >= qVal) {
                        continue;
                    }

                    points += 1;

                    for (int[] d : dir) {
                        int newRow = currentRow + d[0];
                        int newCol = currentCol + d[1];

                        if (newRow >= 0 && newCol >= 0 &&
                                newRow < rows && newCol < cols &&
                                !visited[newRow][newCol] && grid[newRow][newCol] < qVal) {
                            bfsQueue.offer(new int[] { newRow, newCol });
                            visited[newRow][newCol] = true;

                        }
                    }
                }
            }
            ans[queryIdx] = points;
        }

        return ans;
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        int k = queries.size();
        vector<int> ans(k);
        int rows = grid.size(), cols = grid[0].size();
        int points = 0;

        vector<vector<int>> dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int queryIdx = 0; queryIdx < k; queryIdx++) {
            int qVal = queries[queryIdx];
            queue<pair<int, int>> bfsQueue;
            vector<vector<bool>> visited(rows, vector<bool>(cols, false));

            bfsQueue.push({ 0, 0 });
            visited[0][0] = true;
            points = 0;

            while (!bfsQueue.empty()) {
                int qSize = bfsQueue.size();
                for (int i = 0; i < qSize; i++) {
                    auto [currentRow, currentCol] = bfsQueue.front();
                    bfsQueue.pop();

                    if (grid[currentRow][currentCol] >= qVal) {
                        continue;
                    }

                    points += 1;

                    for (auto& d : dir) {
                        int newRow = currentRow + d[0];
                        int newCol = currentCol + d[1];

                        if (newRow >= 0 && newCol >= 0 &&
                                newRow < rows && newCol < cols &&
                                !visited[newRow][newCol] && grid[newRow][newCol] < qVal) {
                            bfsQueue.push({ newRow, newCol });
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }
            ans[queryIdx] = points;
        }

        return ans;
    }
};
```

---

### Method - 2 [Sorted Queries + MinHeap]

#### Java
```java
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int[] ans = new int[k];
        int rows = grid.length, cols = grid[0].length;
        int totalPoints = 0;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[rows][cols];
        int[][] sortedQueries = new int[k][2];

        for(int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        minHeap.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;

        for(int[] query : sortedQueries) {
            int val = query[0], idx = query[1];
            while(!minHeap.isEmpty() && minHeap.peek()[0] < val) {
                int[] cell = minHeap.poll();
                totalPoints++;

                for(int[] d : dir) {
                    int currRow = cell[1] + d[0];
                    int currCol = cell[2] + d[1];

                    if(currRow >= 0 && currCol >= 0 && currRow < rows && currCol < cols && !visited[currRow][currCol]) {
                        minHeap.offer(new int[] {grid[currRow][currCol], currRow, currCol});
                        visited[currRow][currCol] = true;
                    }
                }

            }

            ans[idx] = totalPoints;
        }

        return ans;
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        int k = queries.size();
        vector<int> ans(k);
        int rows = grid.size(), cols = grid[0].size();
        int totalPoints = 0;

        vector<vector<int>> dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        priority_queue<array<int, 3>, vector<array<int, 3>>, greater<>> minHeap;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        vector<array<int, 2>> sortedQueries(k);

        for(int i = 0; i < k; i++) {
            sortedQueries[i] = { queries[i], i };
        }
        sort(sortedQueries.begin(), sortedQueries.end());

        minHeap.push({ grid[0][0], 0, 0 });
        visited[0][0] = true;

        for(auto& query : sortedQueries) {
            int val = query[0], idx = query[1];
            while(!minHeap.empty() && minHeap.top()[0] < val) {
                auto [cellValue, row, col] = minHeap.top();
                minHeap.pop();
                totalPoints++;

                for(auto& d : dir) {
                    int currRow = row + d[0];
                    int currCol = col + d[1];

                    if(currRow >= 0 && currCol >= 0 && currRow < rows && currCol < cols && !visited[currRow][currCol]) {
                        minHeap.push({ grid[currRow][currCol], currRow, currCol });
                        visited[currRow][currCol] = true;
                    }
                }
            }

            ans[idx] = totalPoints;
        }

        return ans;
    }
};
```
