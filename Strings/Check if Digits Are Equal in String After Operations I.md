Leetcode Question : [Check if Digits Are Equal in String After Operations I](https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/)

### Java

```java
class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int num1 = 0, num2 = 0, result;

        while(n > 2) {
            for(int i = 0; i < n - 1; i++) {
                num1 = sb.charAt(i);
                num2 = sb.charAt(i + 1);
                result = (num1 + num2) % 10;
                sb.setCharAt(i, (char)result);
            }
            n--;
        }

        return sb.charAt(0) == sb.charAt(1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasSameDigits(string s) {
        string sb = s;
        int n = sb.length();
        int num1 = 0, num2 = 0, result;

        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                num1 = sb[i];
                num2 = sb[i + 1];
                result = (num1 + num2) % 10;
                sb[i] = (char)result;
            }
            n--;
        }

        return sb[0] == sb[1];
    }
};
```
