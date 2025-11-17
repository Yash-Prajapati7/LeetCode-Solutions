Leetcode Question : [Check if all 1's are at least length K places away](https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/)

### Java

```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int previousOne = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(previousOne == -1) {
                    previousOne = i;
                }
                else if((i - previousOne - 1) < k) {
                    return false;
                }
                else {
                    previousOne = i;
                }
            }
        }

        return true;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        int previousOne = -1;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 1) {
                if(previousOne == -1) {
                    previousOne = i;
                }
                else if((i - previousOne - 1) < k) {
                    return false;
                }
                else {
                    previousOne = i;
                }
            }
        }
        return true;
    }
};
```
