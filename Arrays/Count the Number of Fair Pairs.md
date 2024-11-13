Leetcode Question : [Count the Number of Fair Pairs](https://leetcode.com/problems/count-the-number-of-fair-pairs/)

### Java
```java
class Solution {
    private long countPairs(int[] nums, int sum) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0, j = n - 1; i < j; i++) {
            int num1 = nums[i];
            while(i < j && num1 + nums[j] > sum) {
                j--;
            }
            ans += (j - i);
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }
}
```

### C++
```cpp
class Solution {
private:
    long countPairs(vector<int>& nums, int sum) {
        long ans = 0;
        int n = nums.size();
        for (int i = 0, j = n - 1; i < j; i++) {
            int num1 = nums[i];
            while (i < j && num1 + nums[j] > sum) {
                j--;
            }
            ans += (j - i);
        }
        return ans;
    }

public:
    long countFairPairs(vector<int>& nums, int lower, int upper) {
        sort(nums.begin(), nums.end());
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }
};
```
