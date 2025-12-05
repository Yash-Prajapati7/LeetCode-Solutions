Leetcode Question : [Count Partitions With Even Sum Difference](https://leetcode.com/problems/count-partitions-with-even-sum-difference/)

### Java

```java
class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        int current = 0;
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            current += nums[i];
            total -= nums[i];      
            if(((total - current) & 1) == 0) {
                result++;
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
    int countPartitions(vector<int>& nums) {
        int total = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        int current = 0;
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            current += nums[i];
            total -= nums[i];
            if(((total - current) & 1) == 0) {
                result++;
            }
        }

        return result;
    }
};
```
