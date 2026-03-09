Leetcode Question : [Minimum Changes to Make Alternating Binary String](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string)

### Java

```java
class Solution {
    public int minOperations(String s) {
        char[] digits = s.toCharArray();
        int start0 = 0;
        int start1 = 0;
        
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                if (digits[i] == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (digits[i] == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }
        
        return Math.min(start0, start1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(string s) {
        vector<char> digits(s.begin(), s.end());
        int start0 = 0;
        int start1 = 0;
        
        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                if (digits[i] == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (digits[i] == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }
        
        return min(start0, start1);
    }
};
```
