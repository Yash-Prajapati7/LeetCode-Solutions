Leetcode Question : [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/description/)
### Java
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
```

### C++
```cpp
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        map[0] = 1;
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            count += map.count(remove) ? map[remove] : 0; 
            map[prefixSum]++;
        }
        return count;
    }
};
```
**Input:**
* `nums = [1, 1, 1]`
* `k = 2`

**Dry Run:**

1. **Initialization:**
   * `map`: An empty unordered map to store prefix sums and their frequencies. It's initialized with `{0: 1}` to account for the case where an empty subarray has a sum of `k` (if `k` is 0).
   * `prefixSum = 0`:  The running sum of elements encountered so far.
   * `count = 0`: The count of subarrays with sum `k`.

2. **Iteration 1 (i = 0):**
   * `prefixSum += nums[0]` -> `prefixSum = 1` 
   * `remove = prefixSum - k` -> `remove = -1`
   * `count += map.getOrDefault(remove, 0)` -> `count = 0` (since `remove` is not in `map`)
   * `map[prefixSum]++` -> `map` becomes `{0: 1, 1: 1}`

3. **Iteration 2 (i = 1):**
   * `prefixSum += nums[1]` -> `prefixSum = 2`
   * `remove = prefixSum - k` -> `remove = 0`
   * `count += map.getOrDefault(remove, 0)` -> `count = 1` (as `map[0]` exists and equals 1)
   * `map[prefixSum]++` -> `map` becomes `{0: 1, 1: 1, 2: 1}`

4. **Iteration 3 (i = 2):**
   * `prefixSum += nums[2]` -> `prefixSum = 3`
   * `remove = prefixSum - k` -> `remove = 1`
   * `count += map.getOrDefault(remove, 0)` -> `count = 2` (as `map[1]` exists and equals 1)
   * `map[prefixSum]++` -> `map` becomes `{0: 1, 1: 1, 2: 1, 3: 1}`

5. **Return:**
   * The loop finishes, and the function returns `count`, which is **2**.
