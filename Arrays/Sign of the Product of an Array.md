Leetcode Question : [Sign of the Product of an Array](https://leetcode.com/problems/sign-of-the-product-of-an-array/)

### Java
```java
class Solution {
    public int arraySign(int[] nums) {
        int negatives = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                return 0;
            }
            else if(nums[i] < 0) {
                negatives++;
            }
        }
        if(negatives % 2 == 0) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
```

### C++
```cpp
class Solution {
public:
    int arraySign(vector<int>& nums) {
        int negatives = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 0) {
                return 0;
            }
            else if(nums[i] < 0) {
                negatives++;
            }
        }
        if(negatives % 2 == 0) {
            return 1;
        }
        else {
            return -1;
        }
    }
};
```
