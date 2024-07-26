## Leetcode Question : [Binary Subarrays with Sum](https://leetcode.com/problems/binary-subarrays-with-sum/)
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
            sum += nums[right];
            while(sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 = countSubarray(nums, goal);
        int count2 = countSubarray(nums, goal - 1);
        return count1 - count2;
    }
}
```
### C++
```cpp
class Solution {
private:
    int countSubarray(vector<int>& nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.size()) {
            sum += nums[right];
            while (sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int count1 = countSubarray(nums, goal);
        int count2 = countSubarray(nums, goal - 1);
        return count1 - count2;
    }
};
```
