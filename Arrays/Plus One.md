Leetcode Question : [Plus One](https://leetcode.com/problems/plus-one/)

### Java

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        for(int i = 1; i <= n; i++) {
            result[i] = digits[i - 1];
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
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();

        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        vector<int> result(n + 1);
        result[0] = 1;
        for(int i = 1; i <= n; i++) {
            result[i] = digits[i - 1];
        }

        return result;
    }
};
```
