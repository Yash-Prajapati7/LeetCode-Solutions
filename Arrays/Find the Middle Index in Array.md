Leetcode Question : [Find the Middle Index in Array](https://leetcode.com/problems/find-the-middle-index-in-array/)

### Java

```java
class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) total += nums[i];

        int leftSum = 0, rightSum = 0;
        for(int i = 0; i < nums.length; i++) {
            rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        int total = 0;
        for(int i = 0; i < nums.size(); i++) total += nums[i];

        int leftSum = 0, rightSum = 0;
        for(int i = 0; i < nums.size(); i++) {
            rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
};
```
