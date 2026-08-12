Leetcode Question : [Length of Longest Subarray With at Most K Frequency](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)

### Java

```java
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0, start = -1;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);

            while (frequency.get(nums[end]) > k) {
                start++;
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
            }

            ans = Math.max(ans, end - start);
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
    int maxSubarrayLength(vector<int>& nums, int k) {
        int ans = 0, start = -1;
        unordered_map<int, int> frequency;

        for (int end = 0; end < nums.size(); end++) {
            frequency[nums[end]]++;

            while (frequency[nums[end]] > k) {
                start++;
                frequency[nums[start]]--;
            }

            ans = max(ans, end - start);
        }

        return ans;
    }
};
```
