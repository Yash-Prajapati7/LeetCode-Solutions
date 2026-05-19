Leetcode Question : [Minimum Moves to Make Array Complementary](https://leetcode.com/problems/minimum-moves-to-make-array-complementary)

```text
c = target sum we want every pair to become

Possible target sums range from:
2 -> 2 * limit

For current pair (a, b):

------------------------------------------------
Sum Range                  Operations Required
------------------------------------------------
[2, a]                     2 operations
[a+1, a+b-1]              1 operation
[a+b]                     0 operations
[a+b+1, b+limit]          1 operation
[b+limit+1, 2*limit]      2 operations
------------------------------------------------

Instead of updating every sum individually,
we use a difference array to mark where
operation count changes.
```

### Java

```java
class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        // diff[c] stores change in operations required
        // for target pair sum = c
        int[] diff = new int[(limit << 1) + 2];

        int a = 0, b = 0;

        // We process pairs:
        // nums[i] and nums[n - i - 1]
        for(int i = 0; i < (n >> 1); i++) {

            // a = smaller value in pair
            // b = larger value in pair
            if(nums[i] < nums[n - i - 1]) {
                a = nums[i];
                b = nums[n - 1 - i];
            } else {
                a = nums[n - 1 - i];
                b = nums[i];
            }

            // Initially assume all sums need 2 operations
            // Starting from sum = 2
            diff[2] += 2;

            // From sum = a + 1,
            // operations reduce from 2 -> 1
            diff[a + 1] -= 1;

            // At sum = a + b,
            // operations reduce from 1 -> 0
            // because pair already equals target sum
            diff[a + b] -= 1;

            // After sum = a + b,
            // operations increase from 0 -> 1
            diff[a + b + 1] += 1;

            // After sum = b + limit,
            // one operation is no longer enough,
            // so operations increase from 1 -> 2
            diff[b + limit + 1] += 1;
        }

        int minOps = n;

        // Stores operations required for current target sum c
        int currentOps = 0;

        // Prefix sum reconstructs actual operation count
        // for every target sum c
        for(int c = 2; c <= (limit << 1); c++) {

            currentOps += diff[c];

            // Find minimum operations among all target sums
            minOps = minOps > currentOps ? currentOps : minOps;
        }

        return minOps;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    int minMoves(vector<int>& nums, int limit) {

        int n = nums.size();

        // diff[c] stores change in operations required
        // for target pair sum = c
        vector<int> diff((limit << 1) + 2);

        int a = 0, b = 0;

        // We process pairs:
        // nums[i] and nums[n - i - 1]
        for(int i = 0; i < (n >> 1); i++) {

            // a = smaller value in pair
            // b = larger value in pair
            if(nums[i] < nums[n - i - 1]) {
                a = nums[i];
                b = nums[n - 1 - i];
            } else {
                a = nums[n - 1 - i];
                b = nums[i];
            }

            // Initially assume all sums need 2 operations
            // Starting from sum = 2
            diff[2] += 2;

            // From sum = a + 1,
            // operations reduce from 2 -> 1
            diff[a + 1] -= 1;

            // At sum = a + b,
            // operations reduce from 1 -> 0
            // because pair already equals target sum
            diff[a + b] -= 1;

            // After sum = a + b,
            // operations increase from 0 -> 1
            diff[a + b + 1] += 1;

            // After sum = b + limit,
            // one operation is no longer enough,
            // so operations increase from 1 -> 2
            diff[b + limit + 1] += 1;
        }

        int minOps = n;

        // Stores operations required for current target sum c
        int currentOps = 0;

        // Prefix sum reconstructs actual operation count
        // for every target sum c
        for(int c = 2; c <= (limit << 1); c++) {

            currentOps += diff[c];

            // Find minimum operations among all target sums
            minOps = minOps > currentOps ? currentOps : minOps;
        }

        return minOps;
    }
};
```
