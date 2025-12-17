Leetcode Question : [Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

### Java

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] < diff) {
                diff = arr[i] - arr[i - 1];
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] == diff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
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
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int>> result;
        sort(arr.begin(), arr.end());
        int diff = INT_MAX;
        int n = arr.size();

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] < diff) {
                diff = arr[i] - arr[i - 1];
                result.clear();
                result.push_back({arr[i - 1], arr[i]});
            } else if (arr[i] - arr[i - 1] == diff) {
                result.push_back({arr[i - 1], arr[i]});
            }
        }

        return result;
    }
};
```
