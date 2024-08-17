Leetcode Question : [Minimum Moves to Equal Array Elements II](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)

### Java
```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int ans = 0;
        
        for (int num : nums) {
            ans += Math.abs(num - median);
        }
        
        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int median = nums[nums.size() / 2];
        int ans = 0;

        for (int num : nums) {
            ans += abs(num - median);
        }

        return ans;
    }
};
```
