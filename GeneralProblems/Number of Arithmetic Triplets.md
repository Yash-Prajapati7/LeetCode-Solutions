Leetcode Question : [Number of Arithmetic Triplets](https://leetcode.com/problems/number-of-arithmetic-triplets/)  

### Java  
```java
## Method - 1
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) count++;
                }
            }
        }
        return count;
    }
}

## Method - 2
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] count = new boolean[201];
        int twice = diff << 1;
        int ans = 0;
        for(int num : nums) {
            if(num >= twice) {
                if(count[num - diff] && count[num - twice]) ans++;
            }
            count[num] = true;
        }
        return ans;
    }
}
```

### Explanation  
You are looking for a triplet of numbers that have:  

- Indexes `i < j < k`  
- `nums[j] - nums[i] == diff` and `nums[k] - nums[j] == diff`  

Example: `[1,3,5]`, `diff = 2`  

So when you reach `5`, you check backward with the hashmap:  
- `5 - diff = 3`, so you check if you visited `3`.  
- `3 - diff = 1`, or `5 - 2 * diff = 1`. So you check if you visited `1`.  

This works because the array is sorted.
