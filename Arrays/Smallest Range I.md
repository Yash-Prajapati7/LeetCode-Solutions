Leetcode Question : [Smallest Range I](https://leetcode.com/problems/smallest-range-i/)

### Java
```java
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = -1, min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.max(0, (max - min) - (2 * k));
    }
}
```

### C++
```cpp
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        int max = -1, min = INT_MAX;
        for (int num : nums) {
            min = std::min(min, num);
            max = std::max(max, num);
        }

        return max(0, (max - min) - (2 * k));
    }
};
```
