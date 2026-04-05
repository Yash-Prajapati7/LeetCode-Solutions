Leetcode Question : [Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)

### Java

```java
class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if(n == 1) return false;
        int x = 0, y = 0;
        
        for(int i = 0; i < n; i++) {
            switch (moves.charAt(i)) {
                case 'U' :
                    y++;
                    break;
                case 'R' :
                    x++;
                    break;
                case 'D' :
                    y--;
                    break;
                case 'L' :
                    x--;
                    break;
            }
        }

        return (x == 0 && y == 0);
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
        int n = moves.length();
        if(n == 1) return false;
        int x = 0, y = 0;
        
        for(int i = 0; i < n; i++) {
            switch (moves[i]) {
                case 'U' :
                    y++;
                    break;
                case 'R' :
                    x++;
                    break;
                case 'D' :
                    y--;
                    break;
                case 'L' :
                    x--;
                    break;
            }
        }

        return (x == 0 && y == 0);
    }
};
```
