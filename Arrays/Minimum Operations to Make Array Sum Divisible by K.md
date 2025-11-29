Leetcode Question : [Minimum Operations to Make Array Sum Divisible by K](https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k)

### Java

```java
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum % k;
    }
};
```
