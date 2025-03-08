Leetcode Question : [Minimum Recolors to Get K Consecutive Black Blocks](https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/)

### Java
```java
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        char[] colors = blocks.toCharArray();
        for(int i = 0; i < k; i++) {
            if(colors[i] == 'W') whiteCount++;
        }

        int ans = whiteCount;

        for(int i = k; i < colors.length; i++) {
            if(colors[i] == 'W') whiteCount++;
            if(colors[i - k] == 'W') whiteCount--;
            ans = ans > whiteCount ? whiteCount : ans;
        }

        return ans;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int whiteCount = 0;
        for(int i = 0; i < k; i++) {
            if(blocks[i] == 'W') whiteCount++;
        }

        int ans = whiteCount;

        for(int i = k; i < blocks.size(); i++) {
            if(blocks[i] == 'W') whiteCount++;
            if(blocks[i - k] == 'W') whiteCount--;
            ans = min(ans, whiteCount);
        }

        return ans;
    }
};
```
