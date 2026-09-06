### Leetcode Question : [Smallest Stable Index I](https://leetcode.com/problems/smallest-stable-index-i/)

### Java

```java
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int max = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max = -1;
            min = Integer.MAX_VALUE;

            for (int ptr1 = 0; ptr1 <= i; ptr1++) {
                max = max < nums[ptr1] ? nums[ptr1] : max;
            }

            for (int ptr2 = i; ptr2 < n; ptr2++) {
                min = min > nums[ptr2] ? nums[ptr2] : min;
            }

            if ((max - min) <= k) {
                return i;
            }
        }

        return -1;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n = nums.size();

        if (n == 1) {
            return 0;
        }

        int max = -1, min = INT_MAX;

        for (int i = 0; i < n; i++) {
            max = -1;
            min = INT_MAX;

            for (int ptr1 = 0; ptr1 <= i; ptr1++) {
                max = max < nums[ptr1] ? nums[ptr1] : max;
            }

            for (int ptr2 = i; ptr2 < n; ptr2++) {
                min = min > nums[ptr2] ? nums[ptr2] : min;
            }

            if ((max - min) <= k) {
                return i;
            }
        }

        return -1;
    }
};
```
