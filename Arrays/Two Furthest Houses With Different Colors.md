Leetcode Question : [Two Furthest Houses With Different Colors](https://leetcode.com/problems/two-furthest-houses-with-different-colors)

### Java

```java
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        if(colors[0] != colors[n - 1]) {
            return n - 1;
        }

        int result = 0;
        int j = n - 1;
        while(j >= 1) {
            if(colors[j] != colors[0]) {
                result = j;
                break;
            }
            j--;
        }

        j = 0;
        while(j < n - 1) {
            if(colors[j] != colors[n - 1]) {
                return result < (n - j - 1) ? (n - j - 1) : result;
            }
            j++;
        }

        return 0;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        if(colors[0] != colors[n - 1]) {
            return n - 1;
        }

        int result = 0;
        int j = n - 1;
        while(j >= 1) {
            if(colors[j] != colors[0]) {
                result = j;
                break;
            }
            j--;
        }

        j = 0;
        while(j < n - 1) {
            if(colors[j] != colors[n - 1]) {
                return result < (n - j - 1) ? (n - j - 1) : result;
            }
            j++;
        }

        return 0;
    }
};
```
