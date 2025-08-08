Leetcode Question : [Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin)

### Java

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0, down = 0, left = 0, right = 0;
        for(char c : moves.toCharArray()) {
            switch(c) {
                case 'U' :
                    up++;
                    break;
                case 'D' :
                    down++;
                    break;
                case 'L' :
                    left++;
                    break;
                case 'R' :
                    right++;
                    break;
            }
        }

        return ((up == down) && (left == right));
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool judgeCircle(string moves) {
        int up = 0, down = 0, left = 0, right = 0;
        for(char c : moves) {
            switch(c) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    down++;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
            }
        }
        return (up == down && left == right);
    }
};
```
