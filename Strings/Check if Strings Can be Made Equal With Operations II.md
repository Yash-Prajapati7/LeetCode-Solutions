Leetcode Question : [Check if Strings Can be Made Equal With Operations II](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/)

### Java

```java
class Solution {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[256]; // 0 - 127 even indices char freq count
                                    // 128 - 255 odd indices char freq count

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) << 7;
            count[offset + s1.charAt(i)]++;
            count[offset + s2.charAt(i)]--;
        }

        for(int i = 0; i < 256; i++) {
            if(count[i] != 0) return false;
        }

        return true;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkStrings(string s1, string s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        vector<int> count(256, 0); // 0 - 127 even indices char freq count
                                  // 128 - 255 odd indices char freq count

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) << 7;
            count[offset + s1[i]]++;
            count[offset + s2[i]]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
};
```
