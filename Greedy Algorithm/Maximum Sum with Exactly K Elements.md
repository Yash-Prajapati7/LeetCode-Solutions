Leetcode Question : [Maximum Sum with Exactly K Elements](https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/)

## Method - 1
```java
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int ans = 0;
        while(k-- > 0) {
            ans += max;
            max += 1;
        }
        return ans;
    }
}
```

## Method - 2
```java
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return (max * k) + (k * (k - 1)) / 2;
    } 
}
```
### Explaination for using `return (max * k) + (k * (k - 1)) / 2;`
1. **`max * k`**: This part calculates the sum of `k` elements, where each element is the maximum value (`max`) found in the array `nums`.

2. **`(k - 1) * k / 2`**: This term adds an additional sum that represents the sum of the first `k - 1` natural numbers. It accounts for the fact that the sequence can include values less than the maximum (`max`) due to the sequence extending `k` elements in total. The arithmetic progression adds these values to the sum to get the final result.
