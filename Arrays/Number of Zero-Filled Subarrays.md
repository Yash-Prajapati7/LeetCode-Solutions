Leetcode Question : [Number of Zero-Filled Subarrays](https://leetcode.com/problems/number-of-zero-filled-subarrays)

### Java

```java
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int consecutive = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                ans = ans + consecutive + 1;
                consecutive++;
            }
            else {
                consecutive = 0;
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
    long long zeroFilledSubarray(vector<int>& nums) {
        long long ans = 0;
        int consecutive = 0;

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 0) {
                ans = ans + consecutive + 1;
                consecutive++;
            }
            else {
                consecutive = 0;
            }
        }

        return ans;
    }
};
```
