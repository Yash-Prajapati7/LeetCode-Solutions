Leetcode Question : [Find Subsequence of Length K With the Largest Sum](https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/)

## Method - 1

### Java

```java
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return new int[] {nums[0]};
        }

        int[][] indices = new int[n][2];
        for(int i = 0; i < n; i++) {
            indices[i][0] = i;
            indices[i][1] = nums[i];
        }

        Arrays.sort(indices, (x1, x2) -> x2[1] - x1[1]);
        Arrays.sort(indices, 0, k, (x1, x2) -> x1[0] - x2[0]);

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = indices[i][1];
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
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        if (n == 1) {
            return {nums[0]};
        }

        vector<pair<int, int>> indices(n);
        for (int i = 0; i < n; i++) {
            indices[i] = {i, nums[i]};
        }

        sort(indices.begin(), indices.end(), [](auto& a, auto& b) {
            return a.second > b.second;
        });

        sort(indices.begin(), indices.begin() + k, [](auto& a, auto& b) {
            return a.first < b.first;
        });

        vector<int> ans(k);
        for (int i = 0; i < k; i++) {
            ans[i] = indices[i].second;
        }

        return ans;
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);

        Arrays.sort(sorted);

        int threshold = sorted[n - k];
        int thresholdCnt = 0;
        for (int i = n - k; i < n; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }

        int[] ans = new int[k];

        int p = 0;
        for (int num : nums) {
            if (num > threshold) {
                ans[p++] = num;
            } else if (num == threshold && thresholdCnt > 0) {
                ans[p++] = num;
                thresholdCnt--;
            }
            if (p== k) {
                break;
            }
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
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> sorted(nums);

        sort(sorted.begin(), sorted.end());

        int threshold = sorted[n - k];
        int thresholdCnt = 0;
        for (int i = n - k; i < n; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }

        vector<int> ans;
        for (int num : nums) {
            if (num > threshold) {
                ans.push_back(num);
            } else if (num == threshold && thresholdCnt > 0) {
                ans.push_back(num);
                thresholdCnt--;
            }
            if (ans.size() == k) {
                break;
            }
        }

        return ans;
    }
};
```
