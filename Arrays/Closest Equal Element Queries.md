Leetcode Question : [Closest Equal Element Queries](https://leetcode.com/problems/closest-equal-element-queries/)

## Approach - 1 (Brute Force - TLE)

### Java

```java
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length;
        int ans = n;
        List<Integer> result = new ArrayList<>(m);

        for(int i = 0; i < m; i++) {
            int idx = queries[i];
            ans = n;
            for(int j = 0; j < n; j++) {
                if(j != idx) {
                    if(nums[j] == nums[idx]) {
                        int dist = Math.abs(j - idx);
                        ans = Math.min(ans, Math.min(dist, n - dist));
                    }
                }
            }

            if(ans == n) {
                result.add(-1);
            }
            else {
                result.add(ans);
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
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int m = queries.size();
        int n = nums.size();
        int ans = n;
        vector<int> result;
        result.reserve(m);

        for(int i = 0; i < m; i++) {
            int idx = queries[i];
            ans = n;
            for(int j = 0; j < n; j++) {
                if(j != idx) {
                    if(nums[j] == nums[idx]) {
                        int dist = abs(j - idx);
                        ans = min(ans, min(dist, n - dist));
                    }
                }
            }

            if(ans == n) {
                result.push_back(-1);
            }
            else {
                result.push_back(ans);
            }
        }

        return result;
    }
};
```

## Approach - 2 (Optimised)

### Java

```java
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = -n; i < n; i++) {
            if (i >= 0) {
                left[i] = pos.getOrDefault(nums[i], i - n);
            }
            pos.put(nums[(i + n) % n], i);
        }

        pos.clear();
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (i < n) {
                right[i] = pos.getOrDefault(nums[i], i + n);
            }
            pos.put(nums[i % n], i);
        }

        List<Integer> result = new ArrayList<>();
        int temp = -1;
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i];
            if (x - left[x] == n) {
                result.add(-1);
            } else {
                temp = x - left[x] < right[x] - x ? x - left[x] : right[x] - x;
                result.add(temp);
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
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int n = nums.size();
        vector<int> left(n), right(n);

        unordered_map<int, int> pos;
        for (int i = -n; i < n; i++) {
            if (i >= 0) {
                if (pos.find(nums[i]) != pos.end())
                    left[i] = pos[nums[i]];
                else
                    left[i] = i - n;
            }
            pos[nums[(i + n) % n]] = i;
        }

        pos.clear();
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (i < n) {
                if (pos.find(nums[i]) != pos.end())
                    right[i] = pos[nums[i]];
                else
                    right[i] = i + n;
            }
            pos[nums[i % n]] = i;
        }

        vector<int> result;
        int temp = -1;
        for (int i = 0; i < queries.size(); i++) {
            int x = queries[i];
            if (x - left[x] == n) {
                result.push_back(-1);
            } else {
                temp = (x - left[x] < right[x] - x) ? (x - left[x]) : (right[x] - x);
                result.push_back(temp);
            }
        }

        return result;
    }
};
```
