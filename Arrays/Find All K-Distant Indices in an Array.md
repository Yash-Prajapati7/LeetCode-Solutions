Leetcode Question : [Find All K-Distant Indices in an Array](https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/)

### Java

```java
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == key) {
                start = Math.max(end, i - k);
                end = Math.min(n - 1, i + k) + 1;
                for(int j = start; j < end; j++) {
                    ans.add(j);
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
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        int n = nums.size();
        vector<int> ans;
        int start = 0, end = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == key) {
                start = max(end, i - k);
                end = min(n - 1, i + k) + 1;
                for(int j = start; j < end; j++) {
                    ans.push_back(j);
                }
            }
        }

        return ans;
    }
};
```
