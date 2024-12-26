Leetcode Question: [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)

### Java

```java
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = nums;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
    }
}
```

### C++

```cpp
class NumArray {
private:
    vector<int> prefix;
public:
    NumArray(vector<int>& nums) {
        prefix = nums;
        for(int i = 1; i < nums.size(); i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }
    
    int sumRange(int left, int right) {
        return left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
    }
};
```
