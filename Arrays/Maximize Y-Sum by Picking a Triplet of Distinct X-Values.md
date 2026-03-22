Leetcode Question : [Maximize Y-Sum by Picking a Triplet of Distinct X-Values](https://leetcode.com/problems/maximize-y-sum-by-picking-a-triplet-of-distinct-x-values/)

## Method - 1

### Java

```java
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Store max y for each distinct x
        for (int i = 0; i < n; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        // Step 2: If less than 3 distinct x → not possible
        if (map.size() < 3) return -1;

        // Step 3: Get all values and sort descending
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());

        // Step 4: Take top 3
        return values.get(0) + values.get(1) + values.get(2);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSumDistinctTriplet(vector<int>& x, vector<int>& y) {
        int n = x.size();

        unordered_map<int, int> mp;

        // Step 1: Store max y for each distinct x
        for (int i = 0; i < n; i++) {
            mp[x[i]] = max(mp[x[i]], y[i]);
        }

        // Step 2: If less than 3 distinct x → not possible
        if (mp.size() < 3) return -1;

        // Step 3: Collect values and sort descending
        vector<int> vals;
        for (auto &p : mp) {
            vals.push_back(p.second);
        }

        sort(vals.begin(), vals.end(), greater<int>());

        // Step 4: Take top 3
        return vals[0] + vals[1] + vals[2];
    }
};
```

## Method - 2 (Optimised Method 1)

### Java

```java
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: max y for each x
        for (int i = 0; i < n; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        // Step 2: need at least 3 distinct x
        if (map.size() < 3) return -1;

        // Step 3: track top 3 values
        int first = 0, second = 0, third = 0;

        for (int val : map.values()) {
            if (val > first) {
                third = second;
                second = first;
                first = val;
            } else if (val > second) {
                third = second;
                second = val;
            } else if (val > third) {
                third = val;
            }
        }

        return first + second + third;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSumDistinctTriplet(vector<int>& x, vector<int>& y) {
        int n = x.size();

        unordered_map<int, int> mp;

        // Step 1: max y for each x
        for (int i = 0; i < n; i++) {
            mp[x[i]] = max(mp[x[i]], y[i]);
        }

        // Step 2: need at least 3 distinct x
        if (mp.size() < 3) return -1;

        // Step 3: track top 3
        int first = 0, second = 0, third = 0;

        for (auto &p : mp) {
            int val = p.second;

            if (val > first) {
                third = second;
                second = first;
                first = val;
            } else if (val > second) {
                third = second;
                second = val;
            } else if (val > third) {
                third = val;
            }
        }

        return first + second + third;
    }
};
```
