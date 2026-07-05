Leetcode Question : [Count Subarrays With Majority Element II](https://leetcode.com/problems/count-subarrays-with-majority-element-ii/)

### Java

```java
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int prefix = 0;
        int totalPrefixLessThanCurrent = 0;
        int offset = n;
        long result = 0;

        int[] freq = new int[(n << 1) + 1]; // Frequency of prefix.

        freq[n] = 1; // prefix = 0 => occurred once

        for (int num : nums) {
            if (num == target) {
                totalPrefixLessThanCurrent += freq[prefix + offset];
                prefix++; // we map target to +1 and all other elements to -1
            } else {
                prefix--;
                totalPrefixLessThanCurrent -= freq[prefix + offset];
            }

            result += totalPrefixLessThanCurrent;
            freq[prefix + offset]++;
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
    long long countMajoritySubarrays(vector<int>& nums, int target) {
        int n = nums.size();
        int prefix = 0;
        int totalPrefixLessThanCurrent = 0;
        int offset = n;
        long long result = 0;

        vector<int> freq((n << 1) + 1, 0); // Frequency of prefix.

        freq[n] = 1; // prefix = 0 => occurred once

        for (int num : nums) {
            if (num == target) {
                totalPrefixLessThanCurrent += freq[prefix + offset];
                prefix++; // we map target to +1 and all other elements to -1
            } else {
                prefix--;
                totalPrefixLessThanCurrent -= freq[prefix + offset];
            }

            result += totalPrefixLessThanCurrent;
            freq[prefix + offset]++;
        }

        return result;
    }
};
```
