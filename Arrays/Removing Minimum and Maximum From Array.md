### Leetcode Question : [Removing Minimum and Maximum From Array](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/)

### Java

```java
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        // Find the indices of the minimum and maximum values
        int minidx = 0,
            maxidx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }

            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int l = Math.min(minidx, maxidx); // The smaller index
        int r = Math.max(minidx, maxidx); // The bigger index

        // Calculate the minimum number of deletions in three cases
        // [0 ...... l ........ r ...... n]
        return Math.min(
            Math.min(r + 1, n - l),
            l + 1 + n - r
        );
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int n = nums.size();

        // Find the indices of the minimum and maximum values
        int minidx = 0,
            maxidx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }

            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int l = min(minidx, maxidx); // The smaller index
        int r = max(minidx, maxidx); // The bigger index

        // Calculate the minimum number of deletions in three cases
        // [0 ...... l ........ r ...... n]
        return min(
            min(r + 1, n - l),
            l + 1 + n - r
        );
    }
};
```
