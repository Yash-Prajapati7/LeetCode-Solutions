Leetcode Question : [Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/)

### Java
```java
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();

        // Step 1: Build a decreasing stack (based on values at indices)
        for (int i = 0; i < n; i++) {
            if (s.isEmpty() || nums[s.peek()] > nums[i]) {
                s.push(i);
            }
        }

        int ans = 0;

        // Step 2: Traverse from the right and calculate maximum width
        for (int j = n - 1; j >= 0; j--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[j]) {
                ans = Math.max(ans, j - s.pop());
            }
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n = nums.size();
        stack<int> s;

        // Step 1: Build a decreasing stack (based on values at indices)
        for (int i = 0; i < n; i++) {
            if (s.empty() || nums[s.top()] > nums[i]) {
                s.push(i);
            }
        }

        int ans = 0;

        // Step 2: Traverse from the right and calculate maximum width
        for (int j = n - 1; j >= 0; j--) {
            while (!s.empty() && nums[s.top()] <= nums[j]) {
                ans = max(ans, j - s.top());
                s.pop();
            }
        }

        return ans;
    }
};
```
