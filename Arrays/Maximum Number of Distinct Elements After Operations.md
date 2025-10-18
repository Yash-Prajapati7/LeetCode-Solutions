Leetcode Question : [Maximum Number of Distinct Elements After Operations](https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations)

### Java

```java
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // If ( len(nums) <= 2*k + 1 ) then all elements can be made unique
        if (nums.length <= (k << 1) + 1) return nums.length;

        Arrays.sort(nums);
        int uniques = 0;
        int prev = Integer.MIN_VALUE;
        int current = 0;

        for(int num : nums) {
            current = Math.min(Math.max(num - k, prev + 1), num + k);
            if(current > prev) {
                uniques++;
                prev = current;
            }
        }

        return uniques;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistinctElements(vector<int>& nums, int k) {
        if (nums.size() <= (k << 1) + 1) return nums.size();

        sort(nums.begin(), nums.end());
        int uniques = 0;
        int prev = INT_MIN;
        int current = 0;

        for (int num : nums) {
            current = min(max(num - k, prev + 1), num + k);
            if (current > prev) {
                uniques++;
                prev = current;
            }
        }

        return uniques;
    }
};
```
