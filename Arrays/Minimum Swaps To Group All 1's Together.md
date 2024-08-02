Leetcode Question : [Minimum Swaps To Group All 1's Together](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/)
### Java
```java
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for(int num : nums) {
            if(num == 1) {
                ones++;
            }
        }

        if(ones == 0) {
            return 0;
        }

        // Initialise the sliding window
        int zeros = 0;
        for(int i = 0; i < ones; i++) {
            if(nums[i] == 0) {
                zeros++;
            }
        }    

        int minSwaps = zeros;

        // Pointers for the sliding window
        int left = 0;
        int right = ones;

        while(right < (2 * n)) {    // We did (2 * n) to satisfy the circular array condtion
            if(nums[left % n] == 0) {
                zeros--;    // It means that the zero will be leaving the window
            }
            if(nums[right % n] == 0) {
                zeros++ ;    // It means that the zero will be added in the window
            }
            minSwaps = Math.min(minSwaps, zeros);
            left++;
            right++;
        }

        return minSwaps;
    }
}
```
### C++
```cpp
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minSwaps(vector<int>& nums) {
        int n = nums.size();
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        if (ones == 0) {
            return 0;
        }

        // Initialize the sliding window
        int zeros = 0;
        for (int i = 0; i < ones; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
        }

        int minSwaps = zeros;

        // Pointers for the sliding window
        int left = 0;
        int right = ones;

        while (right < (2 * n)) { // We did (2 * n) to satisfy the circular array condition
            if (nums[left % n] == 0) {
                zeros--; // It means that the zero will be leaving the window
            }
            if (nums[right % n] == 0) {
                zeros++; // It means that the zero will be added in the window
            }
            minSwaps = min(minSwaps, zeros);
            left++;
            right++;
        }

        return minSwaps;
    }
};
```
