Leetcode Question : [Sum Game](https://leetcode.com/problems/sum-game/)

### Java

```java
class Solution {
    public boolean sumGame(String num) {
        int len = num.length();
        int leftQ = 0, rightQ = 0;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < (len >> 1); i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += (num.charAt(i) - '0');
            }
        }

        for (int i = (len >> 1); i < len; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += (num.charAt(i) - '0');
            }
        }

        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        return (leftSum - rightSum) != (((rightQ - leftQ) * 9) >> 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool sumGame(string num) {
        int len = num.length();
        int leftQ = 0, rightQ = 0;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < (len >> 1); i++) {
            if (num[i] == '?') {
                leftQ++;
            } else {
                leftSum += (num[i] - '0');
            }
        }

        for (int i = (len >> 1); i < len; i++) {
            if (num[i] == '?') {
                rightQ++;
            } else {
                rightSum += (num[i] - '0');
            }
        }

        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        return (leftSum - rightSum) != (((rightQ - leftQ) * 9) >> 1);
    }
};
```
