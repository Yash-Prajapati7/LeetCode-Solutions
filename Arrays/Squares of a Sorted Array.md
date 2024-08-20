Leetcode Question : [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

### Java
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            int num1 = nums[left];
            int num2 = nums[right];
            if(num1 * num1 >= num2 * num2) {
                result[i] = num1 * num1;
                left++;
            }
            else {
                result[i] = num2 * num2;
                right--;
            }
        }

        return result;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        vector<int> result(nums.size());

        for(int i = nums.size() - 1; i >= 0; i--) {
            int num1 = nums[left];
            int num2 = nums[right];
            if(num1 * num1 >= num2 * num2) {
                result[i] = num1 * num1;
                left++;
            }
            else {
                result[i] = num2 * num2;
                right--;
            }
        }

        return result;
    }
};
```
