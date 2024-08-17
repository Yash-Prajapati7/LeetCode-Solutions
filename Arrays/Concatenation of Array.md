Leetcode Question: [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/description/)

### Java
```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[2 * n];

        for(int i = 0; i < n; i++) {
            newNums[i] = nums[i];
            newNums[n + i] = nums[i];
        }
        
        return newNums;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int n = nums.size();
        vector<int> newNums(2 * n);

        for(int i = 0; i < n; i++) {
            newNums[i] = nums[i];
            newNums[n + i] = nums[i];
        }
        
        return newNums;
    }
};
```
