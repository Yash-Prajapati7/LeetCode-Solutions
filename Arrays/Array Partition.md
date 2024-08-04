## Leetcode Question : [Array Partition](https://leetcode.com/problems/array-partition/)
### Java
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
```
### C++
```cpp
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int sum = 0;
        for(int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
};
```
