Leetcode Question : [Minimum Cost Path With Edge Reversals](https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/)

### Java

```java
class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] allEdges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            allEdges[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];
            allEdges[x].add(new int[] { y, w });
            allEdges[y].add(new int[] { x, 2 * w });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[] { 0, 0 }); // [distance, node]

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int x = current[1];

            if (x == n - 1) {
                return currDist;
            }

            if (currDist > dist[x]) continue;

            for (int[] neighbor : allEdges[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (currDist + w < dist[y]) {
                    dist[y] = currDist + w;
                    pq.offer(new int[] { dist[y], y });
                }
            }
        }

        return -1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minCost(int n, vector<vector<int>>& edges) {
        vector<vector<pair<int,int>>> allEdges(n);

        for (auto &e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];
            allEdges[x].push_back({y, w});
            allEdges[y].push_back({x, 2 * w});
        }

        vector<int> dist(n, INT_MAX);
        dist[0] = 0;

        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        pq.push({0, 0}); // {distance, node}

        while (!pq.empty()) {
            auto [currDist, x] = pq.top();
            pq.pop();

            if (x == n - 1) {
                return currDist;
            }

            if (currDist > dist[x]) continue;

            for (auto &neighbor : allEdges[x]) {
                int y = neighbor.first;
                int w = neighbor.second;

                if (currDist + w < dist[y]) {
                    dist[y] = currDist + w;
                    pq.push({dist[y], y});
                }
            }
        }

        return -1;
    }
};
```
