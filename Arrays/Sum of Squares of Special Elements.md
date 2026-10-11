Leetcode Question : [Sum of Squares of Special Elements](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

### Java

```
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(n % (i + 1) == 0) {
                ans += (nums[i] * nums[i]);
            }
        }

        return ans;
    }
}
```

### C++

```
class Solution {
public:
    int sumOfSquares(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(n % (i + 1) == 0) {
                ans += (nums[i] * nums[i]);
            }
        }

        return ans;
    }
};
```
