Leetcode Question : https://leetcode.com/problems/subsets/
## Method - 1 (Without recursion) <br>
Time Complexity : O(n * (2 ^ n)) <br>
Space Complexity : O(1)
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < (1 << n); i++) { // Iterate through all 2^n subsets
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) { // Check if j-th bit in i is set
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}

```
## Explaination :
| num | 2 | 1 | 0 |
|-----|---|---|---|
| 0   | 0 | 0 | 0 |
| 1   | 0 | 0 | 1 |
| 2   | 0 | 1 | 0 |
| 3   | 0 | 1 | 1 |
| 4   | 1 | 0 | 0 |
| 5   | 1 | 0 | 1 |
| 6   | 1 | 1 | 0 |
| 7   | 1 | 1 | 1 |

For the input array `nums = [3, 1, 2]`:

### Outer Loop (i):
The outer loop iterates from `0` to `2^n - 1` (in this case from `0` to `7`), generating all possible binary representations of subsets.

### Inner Loop (j):
- The inner loop checks each bit of the binary representation of `i`.
- If the bit is set (`1`), it includes `nums[j]` in the current subset.

Let's see how this works for each value of `i`:

- **i = 0 (000):**
  - `list = []`
  - Explanation: All bits are `0`, so no elements are included in the subset.
  - `result = [[]]`

- **i = 1 (001):**
  - `list = [3]`
  - Explanation: Only the 0th bit is `1`, so include `nums[0]` which is `3`.
  - `result = [[], [3]]`

- **i = 2 (010):**
  - `list = [1]`
  - Explanation: Only the 1st bit is `1`, so include `nums[1]` which is `1`.
  - `result = [[], [3], [1]]`

- **i = 3 (011):**
  - `list = [3, 1]`
  - Explanation: The 0th and 1st bits are `1`, so include `nums[0]` and `nums[1]` which are `3` and `1`.
  - `result = [[], [3], [1], [3, 1]]`

- **i = 4 (100):**
  - `list = [2]`
  - Explanation: Only the 2nd bit is `1`, so include `nums[2]` which is `2`.
  - `result = [[], [3], [1], [3, 1], [2]]`

- **i = 5 (101):**
  - `list = [3, 2]`
  - Explanation: The 0th and 2nd bits are `1`, so include `nums[0]` and `nums[2]` which are `3` and `2`.
  - `result = [[], [3], [1], [3, 1], [2], [3, 2]]`

- **i = 6 (110):**
  - `list = [1, 2]`
  - Explanation: The 1st and 2nd bits are `1`, so include `nums[1]` and `nums[2]` which are `1` and `2`.
  - `result = [[], [3], [1], [3, 1], [2], [3, 2], [1, 2]]`

- **i = 7 (111):**
  - `list = [3, 1, 2]`
  - Explanation: All bits are `1`, so include all elements of `nums`.
  - `result = [[], [3], [1], [3, 1], [2], [3, 2], [1, 2], [3, 1, 2]]`

Thus, the final result will be:

```java
[[], [3], [1], [3, 1], [2], [3, 2], [1, 2], [3, 1, 2]]
```
----   


## Method - 2 (With recursion) <br>
Time Complexity : O(2 ^ n) <br>
Space Complexity : O(n * (2 ^ n))
```java
class Solution {
    private void generateSubsets(int [] nums, List<List<Integer>> result, List<Integer> list, int index) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list)); // Add a copy of the current list
            return;
        }
        list.add(nums[index]);
        generateSubsets(nums, result, list, index + 1);
        list.remove(list.size() - 1); // Remove the last element added
        generateSubsets(nums, result, list, index + 1);
    } 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, result, new ArrayList<>(), 0);
        return result;
    }
}

```
