### Leetcode Question : [Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

### Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = -1, max2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int max1 = -1, max2 = -1;

        for (int i = 0; i < nums.size(); i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
};
```
