Leetcode Question : [https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/)
### Java
````java
import java.util.Arrays;

class Solution {    
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int result = 0;
        
        // Create an array that stores the power of 2
        int[] pow = new int[nums.length];
        pow[0] = 1;
        
        // The reason we are creating an array and not using the inbuilt `pow` function is because
        // it returns a double which leads to lossy conversion and we may not get our desired answer
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
````
### C++
````cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    int numSubseq(std::vector<int>& nums, int target) {
        int mod = 1'000'000'007;

        std::sort(nums.begin(), nums.end());
        int left = 0, right = nums.size() - 1;
        int result = 0;

        // Create an array that stores the power of 2
        std::vector<int> pow(nums.size());
        pow[0] = 1; 

        // The reason we are creating an array and not using the inbuilt `pow` function is because
        // it returns a double which leads to lossy conversion and we may not get our desired answer
        for (int i = 1; i < nums.size(); i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
};
````
