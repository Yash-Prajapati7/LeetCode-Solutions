Leetocde Question : [Jump Game II](https://leetcode.com/problems/jump-game-ii/description/)
```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        int coverage = 0, lastJumpIndex = 0, jumps = 0;

        for(int i = 0; i < n; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if(i == lastJumpIndex) {
                lastJumpIndex = coverage;
                jumps++;

                if(coverage >= n - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
```
## Dry run
Input = `[2, 4, 1, 2, 3, 1, 1, 2]`:

### Initial Setup
- `nums = [2, 4, 1, 2, 3, 1, 1, 2]`
- `n = nums.length = 8`
- `coverage = 0`
- `lastJumpIndex = 0`
- `jumps = 0`

### Iteration Details
1. **Iteration 1 (i = 0):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(0, 0 + 2) = 2`
   - `i == lastJumpIndex` (0 == 0) is true:
     - `lastJumpIndex = coverage = 2`
     - `jumps = 1`
   - Coverage (2) is less than `n-1` (7), so we continue.

2. **Iteration 2 (i = 1):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(2, 1 + 4) = 5`
   - `i == lastJumpIndex` (1 == 2) is false, so no jump is made.

3. **Iteration 3 (i = 2):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(5, 2 + 1) = 5`
   - `i == lastJumpIndex` (2 == 2) is true:
     - `lastJumpIndex = coverage = 5`
     - `jumps = 2`
   - Coverage (5) is less than `n-1` (7), so we continue.

4. **Iteration 4 (i = 3):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(5, 3 + 2) = 5`
   - `i == lastJumpIndex` (3 == 5) is false, so no jump is made.

5. **Iteration 5 (i = 4):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(5, 4 + 3) = 7`
   - `i == lastJumpIndex` (4 == 5) is false, so no jump is made.

6. **Iteration 6 (i = 5):**
   - `coverage = Math.max(coverage, i + nums[i]) = Math.max(7, 5 + 1) = 7`
   - `i == lastJumpIndex` (5 == 5) is true:
     - `lastJumpIndex = coverage = 7`
     - `jumps = 3`
   - Coverage (7) is equal to `n-1` (7), so we return `jumps = 3`.
