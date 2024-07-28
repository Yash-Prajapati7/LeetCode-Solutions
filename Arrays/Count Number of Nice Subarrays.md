Leetcode Question: [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/)

### Java
```java
class Solution {
    private int countSubarray(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int left = 0; 
        int right = 0;
        int sum = 0;
        int count = 0;

        while(right < nums.length) {
            sum += (nums[right] % 2);
            while(sum > goal && left <= right) {
                sum -= (nums[left] % 2);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int count1 = countSubarray(nums, k);
        int count2 = countSubarray(nums, k-1);
        return count1 - count2;
    }
}
```

### C++
```cpp
#include <vector>
using namespace std;

class Solution {
private:
    int countSubarray(vector<int>& nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int left = 0; 
        int right = 0;
        int sum = 0;
        int count = 0;

        while(right < nums.size()) {
            sum += (nums[right] % 2);
            while(sum > goal && left <= right) {
                sum -= (nums[left] % 2);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int count1 = countSubarray(nums, k);
        int count2 = countSubarray(nums, k - 1);
        return count1 - count2;
    }
};
```

## Thought behind this solution
We consider odd numbers as 1 and even numbers as 0. In this way the problem becomes same as [Binary Subarrays with Sum](https://github.com/Yash-Prajapati7/LeetCode-Solutions/blob/main/Arrays/Binary%20Subarrays%20with%20Sum.md)
