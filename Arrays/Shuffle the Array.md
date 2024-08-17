Leetcode Question: [Shuffle the Array](https://leetcode.com/problems/shuffle-the-array/)

### Java
```java
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[nums.length];
        int i = 0, j = n, k = 0;
        while(j < nums.length) {
            if(k % 2 == 0) {
                newNums[k++] = nums[i++];
            }
            else {
                newNums[k++] = nums[j++];
            }
        }
        return newNums;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> newNums(nums.size());
        int i = 0, j = n, k = 0;
        while(j < nums.size()) {
            if(k % 2 == 0) {
                newNums[k++] = nums[i++];
            }
            else {
                newNums[k++] = nums[j++];
            }
        }
        return newNums;
    }
};
```
