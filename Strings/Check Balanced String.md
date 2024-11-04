Leetcode Question : [Check Balanced String](https://leetcode.com/problems/check-balanced-string/)

### Java
```java
class Solution {
    public boolean isBalanced(String num) {
        int oddSum = 0, evenSum = 0;
        for(int i = 0; i < num.length(); i++) {
            if(i % 2 == 0) {
                oddSum += (num.charAt(i) - '0');
            }
            else {
                evenSum += (num.charAt(i) - '0');
            }
        }
        return oddSum == evenSum;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isBalanced(string num) {
        int oddSum = 0, evenSum = 0;
        for(int i = 0; i < num.length(); i++) {
            if(i % 2 == 0) {
                oddSum += (num[i] - '0');
            }
            else {
                evenSum += (num[i] - '0');
            }
        }
        return oddSum == evenSum;
    }
};
```
