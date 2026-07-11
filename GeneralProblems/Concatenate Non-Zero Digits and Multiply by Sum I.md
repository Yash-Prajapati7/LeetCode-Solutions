Leetcode Question : [Concatenate Non-Zero Digits and Multiply by Sum I](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/)

### Java

```java
class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n);
        long x = 0;
        int sum = 0;
        int digit = 0;

        for (int i = 0; i < num.length(); i++) {
            digit = num.charAt(i) - '0';
            if (digit != 0) {
                x = (x * 10) + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long sumAndMultiply(int n) {
        string num = to_string(n);
        long long x = 0;
        int sum = 0;
        int digit = 0;

        for (int i = 0; i < num.length(); i++) {
            digit = num[i] - '0';
            if (digit != 0) {
                x = (x * 10) + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
};
```
