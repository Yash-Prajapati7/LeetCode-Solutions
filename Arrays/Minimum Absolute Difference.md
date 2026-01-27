Leetcode Question : [Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

### Java

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int current = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1] - arr[i];
            if(current < diff) {
                ans.clear();
                diff = current;
            }
            
            if(current == diff) {
                ans.add(List.of(arr[i], arr[i + 1]));
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
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int>> ans;
        sort(arr.begin(), arr.end());
        int diff = INT_MAX;
        int current = 0;

        for(int i = 0; i < arr.size() - 1; i++) {
            current = arr[i + 1] - arr[i];
            if(current < diff) {
                ans.clear();
                diff = current;
            }

            if(current == diff) {
                ans.push_back({arr[i], arr[i + 1]});
            }
        }

        return ans;
    }
};
```
