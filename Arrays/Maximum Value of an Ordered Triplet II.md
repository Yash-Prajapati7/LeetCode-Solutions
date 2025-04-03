Leetcode Question : [Maximum Value of an Ordered Triplet II](https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/)

### Java
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        long current = 0, ans = 0;
        long imax = 0, dmax = 0;
        for(int k = 0; k < nums.length; k++) {
            ans = ans < dmax * nums[k] ? dmax * nums[k] : ans;
            dmax = dmax < imax - nums[k] ? imax - nums[k] : dmax;
            imax = imax < nums[k] ? nums[k] : imax;
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
    long long maximumTripletValue(vector<int>& nums) {
        long long current = 0, ans = 0;
        long long imax = 0, dmax = 0;
        for(int k = 0; k < nums.size(); k++) {
            ans = ans < dmax * nums[k] ? dmax * nums[k] : ans;
            dmax = dmax < imax - nums[k] ? imax - nums[k] : dmax;
            imax = imax < nums[k] ? nums[k] : imax;
        }
        return ans;
    }
};
```
