Leetcode Question : [Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)

### Java

```java
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int side1 = 0, side2 = 0, side3 = 0;
        
        for(int i = n - 1; i >= 2; i--) {
            side1 = nums[i - 2];
            side2 = nums[i - 1];
            side3 = nums[i];

            if(side1 + side2 > side3) {
                return side1 + side2 + side3;
            }
        }

        return 0;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int side1 = 0, side2 = 0, side3 = 0;

        for(int i = n - 1; i >= 2; i--) {
            side1 = nums[i - 2];
            side2 = nums[i - 1];
            side3 = nums[i];

            if(side1 + side2 > side3) {
                return side1 + side2 + side3;
            }
        }

        return 0;
    }
};
```
