Leetcode Question : [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity)

### Java

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums;
        int[] result = new int[n];

        int i = 0;

        for(int num : nums) {
            if((num & 1) == 0) {
                result[i++] = num;
            }
        }

        for(int num : nums) {
            if((num & 1) != 0) {
                result[i++] = num;
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums;
        vector<int> result(n);

        int i = 0;

        for(int num : nums) {
            if((num & 1) == 0) {
                result[i++] = num;
            }
        }

        for(int num : nums) {
            if((num & 1) != 0) {
                result[i++] = num;
            }
        }

        return result;
    }
};
```
