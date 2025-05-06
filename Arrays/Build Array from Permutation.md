Leetcode Question : [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/)

## Java

```java
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) ans[i] = nums[nums[i]];
        return ans;
    }
}
```

## C++


```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> buildArray(vector<int>& nums) {
        vector<int> ans(nums.size());
        for(int i = 0; i < nums.size(); i++) ans[i] = nums[nums[i]];
        return ans;
    }
};
```
