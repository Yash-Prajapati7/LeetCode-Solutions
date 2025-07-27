Leetcode Question : [Count Hills and Valleys in an Array](https://leetcode.com/problems/count-hills-and-valleys-in-an-array)

### Java

```java
class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int j = 0, k = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            j = i - 1;
            k = i + 1;

            if (nums[i] != nums[i - 1]) {
                if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                        || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                    ans++;
                } else {
                    if (nums[i] == nums[i - 1]) {
                        while (j >= 0 && nums[i] == nums[j]) {
                            j--;
                        }
                    }
                    if (nums[i] == nums[i + 1]) {
                        while (k < n && nums[i] == nums[k]) {
                            k++;
                        }
                    }

                    if (j >= 0 && k < n) {
                        if ((nums[i] > nums[j] && nums[i] > nums[k]) || (nums[i] < nums[j] && nums[i] < nums[k])) {
                            ans++;
                        }
                    }
                }
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
    int countHillValley(vector<int>& nums) {
        int ans = 0;
        int j = 0, k = 0;
        int n = nums.size();

        for (int i = 1; i < n - 1; i++) {
            j = i - 1;
            k = i + 1;

            if (nums[i] != nums[i - 1]) {
                if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                    || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                    ans++;
                } else {
                    if (nums[i] == nums[i - 1]) {
                        while (j >= 0 && nums[i] == nums[j]) {
                            j--;
                        }
                    }
                    if (nums[i] == nums[i + 1]) {
                        while (k < n && nums[i] == nums[k]) {
                            k++;
                        }
                    }

                    if (j >= 0 && k < n) {
                        if ((nums[i] > nums[j] && nums[i] > nums[k]) || (nums[i] < nums[j] && nums[i] < nums[k])) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
};
```
