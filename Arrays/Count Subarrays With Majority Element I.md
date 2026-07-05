Leetcode Question : [Count Subarrays With Majority Element I](https://leetcode.com/problems/count-subarrays-with-majority-element-i/)

### Java

```java
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                count += (nums[j] == target ? 1 : -1);
                if (count > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countMajoritySubarrays(vector<int>& nums, int target) {
        int result = 0;
        int count = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                count += (nums[j] == target ? 1 : -1);
                if (count > 0) {
                    result++;
                }
            }
        }

        return result;
    }
};
```
