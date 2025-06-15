Leetcode Question : [Max Difference You Can Get From Changing an Integer](https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/)

### Java

```java
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        int idx = 1;
        String a;
        if(s.charAt(0) == '9') {
            while(idx < n && s.charAt(idx) == '9') {
                idx++;
            }

            if(idx == n) {
                a = s;
            }
            else {
                a = s.replace(s.charAt(idx), '9');
            }
        }
        else {
            a = s.replace(s.charAt(0), '9');
        }

        String b;
        if (s.charAt(0) == '1') {
            idx = 1;
            while (idx < n && (s.charAt(idx) == '0' || s.charAt(idx) == '1')) {
                idx++;
            }
            if (idx == n) {
                b = s;
            } else {
                b = s.replace(s.charAt(idx), '0');
            }
        } else {
            b = s.replace(s.charAt(0), '1');
        }

        return Integer.parseInt(a) - Integer.parseInt(b);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDiff(int num) {
        string s = to_string(num);
        int n = s.length();

        int idx = 1;
        string a;
        if(s[0] == '9') {
            while(idx < n && s[idx] == '9') {
                idx++;
            }

            if(idx == n) {
                a = s;
            }
            else {
                a = s;
                char toReplace = s[idx];
                for(int i = 0; i < n; i++) {
                    if(a[i] == toReplace) a[i] = '9';
                }
            }
        }
        else {
            a = s;
            char toReplace = s[0];
            for(int i = 0; i < n; i++) {
                if(a[i] == toReplace) a[i] = '9';
            }
        }

        string b;
        if (s[0] == '1') {
            idx = 1;
            while (idx < n && (s[idx] == '0' || s[idx] == '1')) {
                idx++;
            }
            if (idx == n) {
                b = s;
            } else {
                b = s;
                char toReplace = s[idx];
                for(int i = 0; i < n; i++) {
                    if(b[i] == toReplace) b[i] = '0';
                }
            }
        } else {
            b = s;
            char toReplace = s[0];
            for(int i = 0; i < n; i++) {
                if(b[i] == toReplace) b[i] = '1';
            }
        }

        return stoi(a) - stoi(b);
    }
};
```
