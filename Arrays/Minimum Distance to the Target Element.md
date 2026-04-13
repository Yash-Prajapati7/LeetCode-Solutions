Leetcode Question : [Minimum Distance to the Target Element](https://leetcode.com/problems/minimum-distance-to-the-target-element)

### Java

```java
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if (nums[start] == target) {
            return 0;
        }

        int n = nums.length;
        int i = start - 1, j = start + 1;

        while (i >= 0 || j < n) {
            if (i >= 0) {
                if (nums[i] == target) {
                    return start - i;
                }
            }
            if (j < n) {
                if (nums[j] == target) {
                    return j - start;
                }
            }
            i--;
            j++;
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
    int getMinDistance(vector<int>& nums, int target, int start) {
        if (nums[start] == target) {
            return 0;
        }

        int n = nums.size();
        int i = start - 1, j = start + 1;

        while (i >= 0 || j < n) {
            if (i >= 0) {
                if (nums[i] == target) {
                    return start - i;
                }
            }
            if (j < n) {
                if (nums[j] == target) {
                    return j - start;
                }
            }
            i--;
            j++;
        }

        return -1;
    }
};
```
