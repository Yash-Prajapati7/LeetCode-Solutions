Leetcode Question : [Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero)

### Java

```java
class Solution {
    public int[] sumZero(int n) {
        if(n == 1) {
            return new int[]{0};
        }
        else if(n == 2) {
            return new int[] {-1, 1};
        }

        int[] result = new int[n];
        int half = n >> 1;
        int var = half;
        for(int i = 0; i < half; i++) {
            result[i] = -var;
            result[n - i - 1] = var;
            var--;
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
    vector<int> sumZero(int n) {
        if(n == 1) {
            return {0};
        }
        else if(n == 2) {
            return {-1, 1};
        }

        vector<int> result(n);
        int half = n >> 1;
        int var = half;
        for(int i = 0; i < half; i++) {
            result[i] = -var;
            result[n - i - 1] = var;
            var--;
        }

        return result;
    }
};
```
