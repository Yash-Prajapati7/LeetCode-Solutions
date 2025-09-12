Leetcode Question : [Vowels Game in a String](https://leetcode.com/problems/vowels-game-in-a-string/)

### Java

```java
class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count != 0;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool doesAliceWin(string s) {
        int count = 0;
        for(char c : s) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count != 0;
    }
};
```
