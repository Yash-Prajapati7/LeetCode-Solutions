Leetcode Question : [Count Equal and Divisible Pairs in an Array](https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/)

### Java
```java
class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        if(n == 1) return 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j] && (i * j) % k == 0) ans++;
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
    int countPairs(vector<int>& nums, int k) {
        int ans = 0;
        int n = nums.size();
        if(n == 1) return 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j] && (i * j) % k == 0) ans++;
            }
        }

        return ans;
    }
};
```
