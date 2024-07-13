Leetcode Question : https://leetcode.com/problems/max-consecutive-ones-iii/description/
### Java
```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zeros = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                zeros++;
            }
            if(zeros > k) {
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if(zeros <= k) {
                maxLength = Math.max(maxLength, (right - left + 1));
            }
            right++;
        }
        return maxLength;
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
    int longestOnes(vector<int>& nums, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zeros = 0;
        while (right < nums.size()) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if (zeros <= k) {
                maxLength = max(maxLength, (right - left + 1));
            }
            right++;
        }
        return maxLength;
    }
};
```
