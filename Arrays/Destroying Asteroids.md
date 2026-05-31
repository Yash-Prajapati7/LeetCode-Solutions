Leetcode Question : [Destroying Asteroids](https://leetcode.com/problems/destroying-asteroids)

### Java

```java
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;

        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > m) {
                return false;
            } else {
                m += asteroids[i];
            }
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
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        sort(asteroids.begin(), asteroids.end());
        long long m = mass;

        for(int i = 0; i < asteroids.size(); i++) {
            if(asteroids[i] > m) {
                return false;
            } else {
                m += asteroids[i];
            }
        }

        return true;
    }
};
```
