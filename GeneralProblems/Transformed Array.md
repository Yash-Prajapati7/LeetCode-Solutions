Leetcode Question : [Transformed Array](https://leetcode.com/problems/transformed-array)

### Java

```java
class Solution {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = (((i + nums[i]) % n) + n) % n;
            result[i] = nums[idx];
        }
        return result;
    }
}
```

### C++

```cpp
class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = (((i + nums[i]) % n) + n) % n;
            result[i] = nums[idx];
        }
        return result;
    }
};
```
