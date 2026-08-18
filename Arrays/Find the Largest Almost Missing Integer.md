Leetcode Question : [Find the Largest Almost Missing Integer](https://leetcode.com/problems/find-the-largest-almost-missing-integer/)

### Java

```java
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int max = -1;

        if (k == n) {
            for (int i = 0; i < n; i++) {
                max = max < nums[i] ? nums[i] : max;
            }
            return max;
        }

        int[] freq = new int[51];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        if (k == 1) {
            max = -1;
            for (int i = 0; i < n; i++) {
                if (freq[nums[i]] == 1) {
                    max = max < nums[i] ? nums[i] : max;
                }
            }
            return max;
        }

        if (freq[nums[0]] == 1) {
            if (freq[nums[n - 1]] == 1) {
                return nums[0] > nums[n - 1] ? nums[0] : nums[n - 1];
            }

            return nums[0];
        } else if (freq[nums[n - 1]] == 1) {
            if (freq[nums[0]] == 1) {
                return nums[0] > nums[n - 1] ? nums[0] : nums[n - 1];
            }
            return nums[n - 1];
        } else {
            return -1;
        }
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int n = nums.size();
        int max = -1;

        if (k == n) {
            for (int i = 0; i < n; i++) {
                max = max < nums[i] ? nums[i] : max;
            }
            return max;
        }

        int freq[51] = {0};
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        if (k == 1) {
            max = -1;
            for (int i = 0; i < n; i++) {
                if (freq[nums[i]] == 1) {
                    max = max < nums[i] ? nums[i] : max;
                }
            }
            return max;
        }

        if (freq[nums[0]] == 1) {
            if (freq[nums[n - 1]] == 1) {
                return nums[0] > nums[n - 1] ? nums[0] : nums[n - 1];
            }

            return nums[0];
        } else if (freq[nums[n - 1]] == 1) {
            if (freq[nums[0]] == 1) {
                return nums[0] > nums[n - 1] ? nums[0] : nums[n - 1];
            }
            return nums[n - 1];
        } else {
            return -1;
        }
    }
};
```
