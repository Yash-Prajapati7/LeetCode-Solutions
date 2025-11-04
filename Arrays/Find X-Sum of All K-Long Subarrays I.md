Leetcode Question : [Find X-Sum of All K-Long Subarrays I](https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/)

### Java

```java
class Solution {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[51]; // since nums[i] ∈ [1, 50]

            // count frequencies in current window
            for (int j = i; j < i + k; ++j) {
                freq[nums[j]]++;
            }

            // create (freq, value) pairs for sorting
            int[][] pairs = new int[51][2];
            for (int val = 1; val <= 50; val++) {
                pairs[val][0] = freq[val]; // frequency
                pairs[val][1] = val;       // value
            }

            // sort descending by frequency, then by value
            Arrays.sort(pairs, (a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // compute x-sum
            int xsum = 0, count = 0;
            for (int[] p : pairs) {
                if (p[0] == 0) continue;
                xsum += p[0] * p[1];
                if (++count == x) break;
            }

            ans[i] = xsum;
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
    vector<int> findXSum(vector<int>& nums, int k, int x) {
        int n = nums.size();
        vector<int> ans(n - k + 1);

        for (int i = 0; i <= n - k; i++) {
            vector<int> freq(51, 0); // since nums[i] ∈ [1, 50]

            // count frequencies in current window
            for (int j = i; j < i + k; ++j) {
                freq[nums[j]]++;
            }

            // create (freq, value) pairs for sorting
            vector<pair<int, int>> pairs(51);
            for (int val = 1; val <= 50; val++) {
                pairs[val] = {freq[val], val};
            }

            // sort descending by frequency, then by value
            sort(pairs.begin(), pairs.end(), [](auto& a, auto& b) {
                if (a.first != b.first) return a.first > b.first;
                return a.second > b.second;
            });

            // compute x-sum
            int xsum = 0, count = 0;
            for (auto& p : pairs) {
                if (p.first == 0) continue;
                xsum += p.first * p.second;
                if (++count == x) break;
            }

            ans[i] = xsum;
        }

        return ans;
    }
};
```
