Leetcode Question : [1-bit and 2-bit Characters](https://leetcode.com/problems/1-bit-and-2-bit-characters/)

### Java

```java
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        int i = bits.size() - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.size() - i) % 2 == 0;
    }
};
```
