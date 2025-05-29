Leetcode Question : [Number of Lines To Write String](https://leetcode.com/problems/number-of-lines-to-write-string/)

### Java

```java
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        result[0] = 1;

        for(int i = 0; i < s.length(); i++) {
            if(result[1] + widths[s.charAt(i) - 'a'] > 100) {
                result[0]++;
                result[1] = widths[s.charAt(i) - 'a'];
            }
            else {
                result[1] += widths[s.charAt(i) - 'a'];
            }
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
    vector<int> numberOfLines(vector<int>& widths, string s) {
        vector<int> result(2, 0);
        result[0] = 1;

        for(int i = 0; i < s.length(); i++) {
            if(result[1] + widths[s[i] - 'a'] > 100) {
                result[0]++;
                result[1] = widths[s[i] - 'a'];
            }
            else {
                result[1] += widths[s[i] - 'a'];
            }
        }

        return result;
    }
};
```
