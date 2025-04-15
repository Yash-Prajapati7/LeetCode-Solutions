Leetcode Question : [Count Good Triplets in an Array](https://leetcode.com/problems/count-good-triplets-in-an-array/)
## Method - 1 (TLE)
### Java
```java
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long ans = 0;
        int n = nums1.length;
        HashMap<Integer, Integer> index2 = new HashMap<>(n);

        for (int i = 0; i < n; i++) index2.put(nums2[i], i);

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int i1 = index2.get(nums1[i]);
                    int i2 = index2.get(nums1[j]);
                    int i3 = index2.get(nums1[k]);
                    if (i1 < i2 && i2 < i3) ans++;
                }
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
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        long long ans = 0;
        int n = nums1.size();
        unordered_map<int, int> index2;

        for (int i = 0; i < n; i++) index2[nums2[i]] = i;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int i1 = index2[nums1[i]];
                    int i2 = index2[nums1[j]];
                    int i3 = index2[nums1[k]];
                    if (i1 < i2 && i2 < i3) ans++;
                }
            }
        }

        return ans;
    }
};
```

---
## Method - 2 (Using Fenwick Tree)
### Java
```java
class FenwickTree {
    private int[] tree;
    public FenwickTree(int n) {
        tree = new int[n + 1];
    }

    public void update(int id, int val) {
        id++;
        while(id < tree.length) {
            tree[id] += val;
            id += (id & -id);
        }
    }

    public int query(int id) {
        id++;
        int ans = 0;
        while(id > 0) {
            ans += tree[id];
            id -= (id & -id);
        }
        return ans;
    }
}

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        int[] reversedMapping = new int[n];

        for(int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        for(int i = 0; i < n; i++) {
            reversedMapping[pos2[nums1[i]]] = i;
        }

        FenwickTree tree = new FenwickTree(n);
        long result = 0;
        int j = 0, left = 0, right = 0;

        for(int val = 0; val < n; val++) {
            j = reversedMapping[val];
            left = tree.query(j);
            tree.update(j, 1);
            right = (n - 1 - j) - (val - left);
            result += (long)left * right;
        }

        return result;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class FenwickTree {
    vector<int> tree;
public:
    FenwickTree(int n) {
        tree.resize(n + 1);
    }

    void update(int id, int val) {
        id++;
        while (id < tree.size()) {
            tree[id] += val;
            id += (id & -id);
        }
    }

    int query(int id) {
        id++;
        int ans = 0;
        while (id > 0) {
            ans += tree[id];
            id -= (id & -id);
        }
        return ans;
    }
};

class Solution {
public:
    long long goodTriplets(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        vector<int> pos2(n), reversedMapping(n);

        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            reversedMapping[pos2[nums1[i]]] = i;
        }

        FenwickTree tree(n);
        long long result = 0;
        int j = 0, left = 0, right = 0;

        for (int val = 0; val < n; val++) {
            j = reversedMapping[val];
            left = tree.query(j);
            tree.update(j, 1);
            right = (n - 1 - j) - (val - left);
            result += (long long)left * right;
        }

        return result;
    }
};
```
