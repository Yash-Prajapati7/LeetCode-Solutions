Leetcode Question : [Minimum Average of Smallest and Largest Elements](https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/)

### Java

```java
class Solution {
    public double minimumAverage(int[] nums) {
        int n = nums.length;
        // insertion sort
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int key = nums[i];
            while(j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }

        int left = 0, right = n - 1;
        double ans = Double.MAX_VALUE;
        double current = 0;

        while(left < right) {
            current = (nums[left++] + nums[right--]) / 2.0;
            ans = ans > current ? current : ans;
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
    double minimumAverage(vector<int>& nums) {
        int n = nums.size();
        // insertion sort
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int key = nums[i];
            while(j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }

        int left = 0, right = n - 1;
        double ans = DBL_MAX;
        double current = 0;

        while(left < right) {
            current = (nums[left++] + nums[right--]) / 2.0;
            ans = ans > current ? current : ans;
        }

        return ans;
    }
};
```
