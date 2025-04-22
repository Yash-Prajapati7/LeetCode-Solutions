Leetcode Question : [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)

### Java
```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int i = 0, j = 0;
        Deque<Integer> max = new ArrayDeque<>();    // Descending order
        Deque<Integer> min = new ArrayDeque<>();    // Ascending order

        for(j = 0; j < n; j++) {
            while(!max.isEmpty() && max.peekLast() < nums[j]) max.pollLast();
            while(!min.isEmpty() && min.peekLast() > nums[j]) min.pollLast();
            max.offerLast(nums[j]);
            min.offerLast(nums[j]);

            int maxRoot = max.peekFirst(), minRoot = min.peekFirst();

            if(maxRoot - minRoot > limit) {
                if(maxRoot == nums[i]) max.pollFirst();
                if(minRoot == nums[i]) min.pollFirst();
                i += 1;
            }
        }

        return j - i;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        int i = 0, j = 0;
        deque<int> max; // Descending order
        deque<int> min; // Ascending order

        for(j = 0; j < n; j++) {
            while(!max.empty() && max.back() < nums[j]) max.pop_back();
            while(!min.empty() && min.back() > nums[j]) min.pop_back();
            max.push_back(nums[j]);
            min.push_back(nums[j]);

            int maxRoot = max.front(), minRoot = min.front();

            if(maxRoot - minRoot > limit) {
                if(maxRoot == nums[i]) max.pop_front();
                if(minRoot == nums[i]) min.pop_front();
                i += 1;
            }
        }

        return j - i;
    }
};
```
