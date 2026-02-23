Leetcode Question : [Check If a String Contains All Binary Codes of Size K](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/)

### Java

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = (1 << k);   // total possible binary numbers of length k = 2^k
        boolean[] seen = new boolean[total];
        int mask = total - 1;   // mask with k bits set to 1 (e.g., k=3 -> 111)
        int hash = 0;
        int lsb = 0;

        for(int i = 0; i < s.length(); i++) {
            lsb = s.charAt(i) - '0';   // current bit (0 or 1)

            /*
             Rolling Hash Logic:
             - Shift hash left to make space for the new bit
             - Apply mask to keep only last k bits (remove oldest bit)
             - OR with current bit to append it as least significant bit

             Example:
             previous hash = 110
             shift left -> 1100
             mask with 111 -> 100
             add new bit 1 -> 101
            */
            hash = ((hash << 1) & mask) | lsb;

            // once we have at least k characters, start checking substrings
            if(i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                total--;
                if(total == 0) return true;   // all possible codes found
            }
        }

        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasAllCodes(string s, int k) {
        int total = (1 << k);   // total possible binary numbers of length k = 2^k
        vector<bool> seen(total, false);
        int mask = total - 1;   // mask with k bits set to 1 (e.g., k=3 -> 111)
        int hash = 0;
        int lsb = 0;

        for(int i = 0; i < s.length(); i++) {
            lsb = s[i] - '0';   // current bit (0 or 1)

            /*
             Rolling Hash Logic:
             - Shift hash left to make space for the new bit
             - Apply mask to keep only last k bits (remove oldest bit)
             - OR with current bit to append it as least significant bit

             Example:
             previous hash = 110
             shift left -> 1100
             mask with 111 -> 100
             add new bit 1 -> 101
            */
            hash = ((hash << 1) & mask) | lsb;

            // once we have at least k characters, start checking substrings
            if(i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                total--;
                if(total == 0) return true;   // all possible codes found
            }
        }

        return false;
    }
};
```
