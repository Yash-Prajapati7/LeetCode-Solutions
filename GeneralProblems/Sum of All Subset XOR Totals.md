Leetcode Question : [Sum of All Subset XOR Totals](https://leetcode.com/problems/sum-of-all-subset-xor-totals/)

## Method - 1 (Recursion and BackTracking)
### Java
```java
class Solution {
    private int helper(int[] nums, int index, int currentXor) {
        if(index == nums.length) return currentXor;
        int withNum = helper(nums, index + 1, currentXor ^ nums[index]);
        int withoutNum = helper(nums, index + 1, currentXor);
        return withNum + withoutNum;
    }
    
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
}
```

## Method - 2 (Bit Manipulation)
### Java
```java
class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int or = 0;
        for(int num : nums) or |= num;
        return or << (n - 1);
    }
}
```

### Explanation
To solve the problem efficiently, we use bitwise operations.  
We notice that the result always has its last `N - 1` bits as 0.  
So instead of calculating every subset's XOR, we take the **bitwise OR** of all numbers to get the combined set bits, and then **left shift** it by `N - 1` to place them correctly.
