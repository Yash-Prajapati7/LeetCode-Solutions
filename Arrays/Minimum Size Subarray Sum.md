Leetcode Question: [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Method 1 - Bruteforce

### Java
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                    if(sum >= target) {
                        ans = Math.min(ans, k - i + 1);
                        break;
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int ans = INT_MAX;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                    if(sum >= target) {
                        ans = min(ans, k - i + 1);
                        break;
                    }
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};
```

---

### Method 2 - Optimal

### Java
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, sum = 0;
        int ans = INT_MAX;
        int n = nums.size();

        for(int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum >= target) {
                ans = min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};
```
