Leetcode Question : [Detect Capital](https://leetcode.com/problems/detect-capital/)

### Java
```java
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;

        char[] w = word.toCharArray();
        boolean isStartCapital = (w[0] >= 'A' && w[0] <= 'Z');
        boolean charCaps = false, prevLower = false;

        for(int i = 1; i < w.length; i++) {
            if(w[i] >= 'A' && w[i] <= 'Z') charCaps = true;
            else prevLower = true;

            if(isStartCapital) {
                if(charCaps && prevLower) return false;
            }
            else if(charCaps) return false;
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
    bool detectCapitalUse(string word) {
        if(word.length() == 1) return true;

        vector<char> w(word.begin(), word.end());
        bool isStartCapital = (w[0] >= 'A' && w[0] <= 'Z');
        bool charCaps = false, prevLower = false;

        for(int i = 1; i < w.size(); i++) {
            if(w[i] >= 'A' && w[i] <= 'Z') charCaps = true;
            else prevLower = true;

            if(isStartCapital) {
                if(charCaps && prevLower) return false;
            }
            else if(charCaps) return false;
        }

        return true;
    }
};
```
