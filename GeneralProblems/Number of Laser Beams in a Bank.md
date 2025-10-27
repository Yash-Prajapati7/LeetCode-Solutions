Leetcode Question : [Number of Laser Beams in a Bank](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/)

### Java

```java
class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;

        for (String row : bank) {
            int ones = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    ones++;
                }
            }

            if (ones > 0) {
                ans += (prev * ones);
                prev = ones;
            }
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
    int numberOfBeams(vector<string>& bank) {
        int prev = 0;
        int ans = 0;

        for (string row : bank) {
            int ones = 0;
            for (char c : row) {
                if (c == '1') {
                    ones++;
                }
            }

            if (ones > 0) {
                ans += (prev * ones);
                prev = ones;
            }
        }

        return ans;
    }
};
```
