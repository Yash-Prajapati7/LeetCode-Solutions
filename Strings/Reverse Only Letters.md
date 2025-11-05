Leetcode Question : [Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters)

### Java

```java
class Solution {
    private boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        if(n == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder(n);
        int j = n - 1;

        for(int i = 0; i < n; i++) {
            if(isAlphabet(s.charAt(i))) {
                while(j >= 0 && !isAlphabet(s.charAt(j))) {
                    j--;
                }

                sb.append(s.charAt(j));
                j--;
            }
            else sb.append(s.charAt(i));
        }

        return new String(sb);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

public:
    string reverseOnlyLetters(string s) {
        int n = s.length();
        if(n == 1) {
            return s;
        }

        string sb;
        sb.reserve(n);
        int j = n - 1;

        for(int i = 0; i < n; i++) {
            if(isAlphabet(s[i])) {
                while(j >= 0 && !isAlphabet(s[j])) {
                    j--;
                }
                sb.push_back(s[j]);
                j--;
            } else {
                sb.push_back(s[i]);
            }
        }

        return sb;
    }
};
```
