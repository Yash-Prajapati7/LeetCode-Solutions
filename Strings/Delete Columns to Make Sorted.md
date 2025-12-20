Leetcode Question : [Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/)

### Java

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        char prev = 'a';
        int len = strs.length;
        int strLen = strs[0].length();
        int count = 0;

        for (int col = 0; col < strLen; col++) {
            prev = strs[0].charAt(col);
            for (int row = 1; row < len; row++) {
                if (strs[row].charAt(col) < prev) {
                    count++;
                    break;
                }
                prev = strs[row].charAt(col);
            }
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        char prev = 'a';
        int len = strs.size();
        int strLen = strs[0].size();
        int count = 0;

        for (int col = 0; col < strLen; col++) {
            prev = strs[0][col];
            for (int row = 1; row < len; row++) {
                if (strs[row][col] < prev) {
                    count++;
                    break;
                }
                prev = strs[row][col];
            }
        }

        return count;
    }
};
```
