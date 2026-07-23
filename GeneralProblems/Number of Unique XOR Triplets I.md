Leetcode Question : [Number of Unique XOR Triplets I](https://leetcode.com/problems/number-of-unique-xor-triplets-i/)

### Java

```java id="v8j1yw"
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }

        int k = (int) Math.floor(Math.log(n) / Math.log(2));
        return (1 << (k + 1));
    }
}
```

### C++

```cpp id="m3p8fk"
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        int n = nums.size();
        if (n < 3) {
            return n;
        }

        int k = (int)floor(log2(n));
        return (1 << (k + 1));
    }
};
```
