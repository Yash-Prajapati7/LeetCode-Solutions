Leetcode Question : [Minimum Distance Between Three Equal Elements I](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/)

### Java

```java
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[j] == nums[k]) {
                            ans = Math.min(ans, k - i);
                            break;
                        }
                    }
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        int n = nums.size();
        int ans = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[j] == nums[k]) {
                            ans = min(ans, k - i);
                            break;
                        }
                    }
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
};
```
