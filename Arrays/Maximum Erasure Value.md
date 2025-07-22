Leetcode Question : [Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value)

### Java

```java
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] present = new boolean[10001];
        int left = 0, right = 0;
        int current = 0, max = 0;
        while(right < nums.length) {
            if(!present[nums[right]]) {
                present[nums[right]] = true;
                current += nums[right];
                right++;
            }
            else {
                present[nums[left]] = false;
                current -= nums[left];
                left++;
            }
            max = max < current ? current : max;
        }

        return max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        vector<bool> present(10001, false);
        int left = 0, right = 0;
        int current = 0, maxVal = 0;
        while (right < nums.size()) {
            if (!present[nums[right]]) {
                present[nums[right]] = true;
                current += nums[right];
                right++;
            } else {
                present[nums[left]] = false;
                current -= nums[left];
                left++;
            }
            maxVal = max(maxVal, current);
        }
        return maxVal;
    }
};
```
