Leetcode Question : [Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)

### Java

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--; // making it '0' based
            ans.append((char)((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }

        return new String(ans.reverse());
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string convertToTitle(int columnNumber) {
        string ans = "";
        while(columnNumber > 0) {
            columnNumber--; // making it '0' based
            ans += (char)((columnNumber % 26) + 'A');
            columnNumber /= 26;
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};
```
