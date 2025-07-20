Leetcode Question : [Next Permutation](https://leetcode.com/problems/next-permutation/)

### Java

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;

        int i = n - 2;
        int temp = 0;
        // Step 1 : find the first element from the end where nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // Step 2 : find the next greater element from the end
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int left = i + 1;
        int right = n - 1;
        while(left < right) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }

        return;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return;

        int i = n - 2;
        int temp = 0;

        // Step 1 : find the first element from the end where nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // Step 2 : find the next greater element from the end
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int left = i + 1;
        int right = n - 1;
        while(left < right) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }

        return;
    }
};
```
