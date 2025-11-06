Leetcode Question : [Power Grid Maintenance](https://leetcode.com/problems/power-grid-maintenance)

### Java

```java
class Solution {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[py] < rank[px]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            dsu.union(u, v);
        }

        Map<Integer, TreeSet<Integer>> componentMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            componentMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] active = new boolean[c + 1];
        Arrays.fill(active, true);

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (active[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = componentMap.get(root);
                    if (set == null || set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } else {
                if (active[x]) {
                    active[x] = false;
                    TreeSet<Integer> set = componentMap.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    struct DSU {
        vector<int> parent, rank;
        DSU(int n) {
            parent.resize(n + 1);
            rank.resize(n + 1, 0);
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void unionSets(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[py] < rank[px]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    };

public:
    vector<int> processQueries(int c, vector<vector<int>>& connections, vector<vector<int>>& queries) {
        DSU dsu(c);

        for (auto& edge : connections) {
            int u = edge[0], v = edge[1];
            dsu.unionSets(u, v);
        }

        unordered_map<int, set<int>> componentMap;
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            componentMap[root].insert(i);
        }

        vector<bool> active(c + 1, true);
        vector<int> result;

        for (auto& q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (active[x]) {
                    result.push_back(x);
                } else {
                    auto it = componentMap.find(root);
                    if (it == componentMap.end() || it->second.empty()) result.push_back(-1);
                    else result.push_back(*it->second.begin());
                }
            } else {
                if (active[x]) {
                    active[x] = false;
                    auto it = componentMap.find(root);
                    if (it != componentMap.end()) it->second.erase(x);
                }
            }
        }

        return result;
    }
};
```
