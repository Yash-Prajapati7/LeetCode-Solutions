Leetcode Question : [Check if Strings Can be Made Equal With Operations II](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii)

### Java

```java
class Solution {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) << 7;
            count1[offset + s1.charAt(i)]++;
            count2[offset + s2.charAt(i)]++;
        }

        return Arrays.equals(count1, count2);
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

        vector<int> count1(256, 0);
        vector<int> count2(256, 0);

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) << 7;
            count1[offset + s1[i]]++;
            count2[offset + s2[i]]++;
        }

        return count1 == count2;
    }
};
```
