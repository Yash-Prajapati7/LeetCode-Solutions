Leetcode Question : [Find Minimum Operations to Make All Elements Divisible by Three](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)

### Java

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for(int num : nums) {
            if(num % 3 != 0) {
                operations++;
            }
        }
        return operations;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int operations = 0;
        for(int num : nums) {
            if(num % 3 != 0) {
                operations++;
            }
        }
        return operations;
    }
};
```
