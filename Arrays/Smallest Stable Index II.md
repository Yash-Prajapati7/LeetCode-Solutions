### Leetcode Question : [Smallest Stable Index II](https://leetcode.com/problems/smallest-stable-index-ii/)

### Java

```java id="4x7mnp"
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int max = -1;
        int start = 0;          // Start of a segment
        int maxAtStart = -1;    // Maximum in nums[start.....i]

        for (int i = 0; i < n; i++) {
            max = max < nums[i] ? nums[i] : max;

            if (i == start) {
                maxAtStart = maxAtStart < nums[i] ? nums[i] : maxAtStart;
            }

            if (maxAtStart - nums[i] > k) {
                start = i + 1;
                maxAtStart = max;
            }
        }

        return start < n ? start : -1;
    }
}
```

### C++

```cpp id="v5qk2r"
using namespace std;

class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n = nums.size();

        if (n == 1) {
            return 0;
        }

        int max = -1;
        int start = 0;          // Start of a segment
        int maxAtStart = -1;    // Maximum in nums[start.....i]

        for (int i = 0; i < n; i++) {
            max = max < nums[i] ? nums[i] : max;

            if (i == start) {
                maxAtStart = maxAtStart < nums[i] ? nums[i] : maxAtStart;
            }

            if (maxAtStart - nums[i] > k) {
                start = i + 1;
                maxAtStart = max;
            }
        }

        return start < n ? start : -1;
    }
};
```
