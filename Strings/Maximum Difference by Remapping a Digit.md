Leetcode Question : [Maximum Difference by Remapping a Digit](https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/)

### Java

```java
class Solution {
    public int minMaxDifference(int num) {
        String s1 = String.valueOf(num);
        String s2 = s1;
        int n = s1.length();
        int index = 0;
        while(index < n && s1.charAt(index) == '9') {
            index++;
        }

        if(index < n) {
            s1 = s1.replace(s1.charAt(index), '9');
        }
        s2 = s2.replace(s2.charAt(0), '0');

        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minMaxDifference(int num) {
        string s = to_string(num);

        // For max value: replace first non-9 digit with 9
        string maxStr = s;
        for (char c : maxStr) {
            if (c != '9') {
                char target = c;
                for (char& ch : maxStr) {
                    if (ch == target) ch = '9';
                }
                break;
            }
        }

        // For min value: replace first digit with 0
        string minStr = s;
        char target = minStr[0];
        for (char& ch : minStr) {
            if (ch == target) ch = '0';
        }

        return stoi(maxStr) - stoi(minStr);
    }
};

```
