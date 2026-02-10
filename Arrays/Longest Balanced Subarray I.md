Leetcode Question : [Longest Balanced Subarray I](https://leetcode.com/problems/longest-balanced-subarray-i/)

### Java

```java
class Solution {
    public int longestBalanced(int[] nums) {
        int current = 0, max = 0;
        int even = 0, odd = 0;

        for (int i = 0; i < nums.length; i++) {
            even = 0;
            odd = 0;
            HashSet<Integer> distinct = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if (!distinct.contains(nums[j])) {
                    if ((nums[j] & 1) == 0) {
                        even++;
                    } else {
                        odd++;
                    }

                    distinct.add(nums[j]);
                }

                if (even == odd) {
                    current = (j - i + 1);
                    max = current > max ? current : max;
                }
            }
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
    int longestBalanced(vector<int>& nums) {
        int current = 0, maxVal = 0;
        int even = 0, odd = 0;

        for (int i = 0; i < nums.size(); i++) {
            even = 0;
            odd = 0;
            unordered_set<int> distinct;

            for (int j = i; j < nums.size(); j++) {
                if (distinct.find(nums[j]) == distinct.end()) {
                    if ((nums[j] & 1) == 0) {
                        even++;
                    } else {
                        odd++;
                    }

                    distinct.insert(nums[j]);
                }

                if (even == odd) {
                    current = (j - i + 1);
                    maxVal = current > maxVal ? current : maxVal;
                }
            }
        }

        return maxVal;
    }
};
```
