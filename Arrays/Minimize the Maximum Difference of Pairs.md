Leetcode Question : [Minimize the Maximum Difference of Pairs](https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/)

### Java

```java
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; // skip the next one to avoid overlapping
            }
        }
        return count >= p;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        sort(nums.begin(), nums.end());
        int low = 0, high = nums.back() - nums.front();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

private:
    bool canFormPairs(vector<int>& nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; // skip next to avoid overlapping
            }
        }
        return count >= p;
    }
};
```
