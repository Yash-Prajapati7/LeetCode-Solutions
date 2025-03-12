Leetcode Question : [Maximum Count of Positive Integer and Negative Integer](https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/)  

### Java  
```java
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if(n == 1 && nums[0] != 0) return 1;
        int left = 0, right = n - 1, mid = 0;
        
        if(nums[0] > 0) return n;
        if(nums[0] == 0 && nums[n - 1] == 0) return 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(nums[mid] > 0) right = mid - 1;
            else left = mid + 1;
        }

        int pos = n - left;
        right = left - 1;
        left = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }

        int neg = left;
        return pos > neg ? pos : neg;
    }
}
```

### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int n = nums.size();
        if(n == 1 && nums[0] != 0) return 1;
        int left = 0, right = n - 1, mid = 0;
        
        if(nums[0] > 0) return n;
        if(nums[0] == 0 && nums[n - 1] == 0) return 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(nums[mid] > 0) right = mid - 1;
            else left = mid + 1;
        }

        int pos = n - left;
        right = left - 1;
        left = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }

        int neg = left;
        return max(pos, neg);
    }
};
```
