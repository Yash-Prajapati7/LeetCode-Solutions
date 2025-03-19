Leetcode Question : [Minimum Operations to Make Binary Array Elements Equal to One I](https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/)

### Java
```java
class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i] == 0 ? 1 : 0;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                operations++;
            }
        }

        if(nums[n- 1] == 0 || nums[n - 2] == 0) return -1;

        return operations;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums) {
        int operations = 0;
        int n = nums.size();

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i] == 0 ? 1 : 0;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                operations++;
            }
        }

        if (nums[n - 1] == 0 || nums[n - 2] == 0) return -1;

        return operations;
    }
};
```
