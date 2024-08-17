Leetcode Question: [Minimum Moves to Equal Array Elements](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)

### Java
```java
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for(int num : nums) {
            min = Math.min(min, num);
        }

        for(int num : nums) {
            ans += (num - min);
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minMoves(vector<int>& nums) {
        int min = INT_MAX;
        int ans = 0;

        for(int num : nums) {
            min = std::min(min, num);
        }

        for(int num : nums) {
            ans += (num - min);
        }

        return ans;
    }
};
```
