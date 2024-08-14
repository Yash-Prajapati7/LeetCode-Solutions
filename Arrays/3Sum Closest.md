Leetcode Question: [3Sum Closest](https://leetcode.com/problems/3sum-closest/)

### Java
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int prevDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

                int diffToTarget = Math.abs(sum - target);
                if (diffToTarget < prevDiff) {
                    result = sum;
                    prevDiff = diffToTarget;
                }
            }
        }
        return result;
    }
}
```

### C++
```cpp
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int result = nums[0] + nums[1] + nums[2];
        int prevDiff = INT_MAX;

        for (int i = 0; i < nums.size() - 2; i++) {
            int left = i + 1;
            int right = nums.size() - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

                int diffToTarget = abs(sum - target);
                if (diffToTarget < prevDiff) {
                    result = sum;
                    prevDiff = diffToTarget;
                }
            }
        }
        return result;
    }
};
```
