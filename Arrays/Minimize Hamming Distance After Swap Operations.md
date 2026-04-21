Leetcode Question : [Minimize Hamming Distance After Swap Operations](https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/)

### Java

```java
class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;

        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        parent[y] = x;

        if (rank[x] == rank[y]) {
            rank[x]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] pair : allowedSwaps) {
            union(pair[0], pair[1]);
        }

        Map<Integer, Map<Integer, Integer>> sets = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            sets.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> countMap = sets.get(root);
            countMap.put(source[i], countMap.getOrDefault(source[i], 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> countMap = sets.get(root);

            if (countMap.getOrDefault(target[i], 0) > 0) {
                countMap.put(target[i], countMap.get(target[i]) - 1);
            } else {
                ans++;
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
    vector<int> parent;
    vector<int> rankArr;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;

        if (rankArr[x] < rankArr[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        parent[y] = x;

        if (rankArr[x] == rankArr[y]) {
            rankArr[x]++;
        }
    }

public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        int n = source.size();
        parent.resize(n);
        rankArr.resize(n, 0);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (auto &pair : allowedSwaps) {
            unionSet(pair[0], pair[1]);
        }

        unordered_map<int, unordered_map<int, int>> sets;

        for (int i = 0; i < n; i++) {
            int root = find(i);
            sets[root][source[i]]++;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i);

            if (sets[root][target[i]] > 0) {
                sets[root][target[i]]--;
            } else {
                ans++;
            }
        }

        return ans;
    }
};
```
