Leetcode Question : [Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)

## Approach - 1

### Java

```java
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);

        HashMap<Integer, Integer> rank = new HashMap<>(n);
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (!rank.containsKey(temp[i])) {
                rank.put(temp[i], count);
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            temp[i] = rank.get(arr[i]);
        }

        System.gc();
        return temp;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) {
            return {};
        }

        vector<int> temp(n);

        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        sort(temp.begin(), temp.end());

        unordered_map<int, int> rank;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (rank.find(temp[i]) == rank.end()) {
                rank[temp[i]] = count;
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            temp[i] = rank[arr[i]];
        }

        return temp;
    }
};
```

## Approach - 2

### Java

```java
class Solution {
    public class Node {
        int num;
        int idx;

        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        int[] ans = new int[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(n, (a, b) -> a.num - b.num);

        for (int i = 0; i < n; i++) {
            pq.offer(new Node(arr[i], i));
        }

        int idx = 0;
        Node current = null;
        Node prev = current;
        int rank = 1;

        while (!pq.isEmpty()) {
            prev = current;
            current = pq.poll();

            if (prev != null && prev.num != current.num) {
                rank++;
            }

            ans[current.idx] = rank;
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
    vector<int> arrayRankTransform(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) {
            return {};
        }

        vector<int> ans(n);

        priority_queue<pair<int, int>,
                       vector<pair<int, int>>,
                       greater<pair<int, int>>> pq;

        for (int i = 0; i < n; i++) {
            pq.push({arr[i], i});
        }

        int current = 0;
        int prev = 0;
        int rank = 1;
        bool hasPrev = false;

        while (!pq.empty()) {
            auto node = pq.top();
            pq.pop();

            current = node.first;

            if (hasPrev && prev != current) {
                rank++;
            }

            ans[node.second] = rank;
            prev = current;
            hasPrev = true;
        }

        return ans;
    }
};
```
