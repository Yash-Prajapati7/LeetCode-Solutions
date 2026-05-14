Leetcode Question : [Check if Array Is Good](https://leetcode.com/problems/check-if-array-is-good/)

### Java

```java
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int duplicate = -1;
        boolean[] set = new boolean[n + 1];

        for (int num : nums) {
            if (num >= n) {
                return false;
            }

            if (!set[num]) {
                set[num] = true;
            } else if (num != n - 1) {
                return false;
            } else if (duplicate != -1) {
                return false;
            } else {
                duplicate = num;
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
    bool isGood(vector<int>& nums) {
        int n = nums.size();
        int duplicate = -1;
        vector<bool> set(n + 1, false);

        for (int num : nums) {
            if (num >= n) {
                return false;
            }

            if (!set[num]) {
                set[num] = true;
            } else if (num != n - 1) {
                return false;
            } else if (duplicate != -1) {
                return false;
            } else {
                duplicate = num;
            }
        }

        return true;
    }
};
```
