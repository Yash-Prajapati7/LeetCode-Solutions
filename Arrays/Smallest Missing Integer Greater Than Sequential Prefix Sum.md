Leetcode Question : [Smallest Missing Integer Greater Than Sequential Prefix Sum](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)

### Java

```java
class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        boolean[] seen = new boolean[51];

        for (int num : nums) {
            seen[num] = true;
        }

        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (total < seen.length && seen[total]) {
            total++;
        }

        return total;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int n = nums.size();

        bool seen[51] = {};

        for (int num : nums) {
            seen[num] = true;
        }

        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (total < 51 && seen[total]) {
            total++;
        }

        return total;
    }
};
```
