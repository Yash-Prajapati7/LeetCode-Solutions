Leetcode Question : [Water Bottles](https://leetcode.com/problems/water-bottles)

### Java

```java
class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while (numBottles >= numExchange) {
            // Consume numExchange full bottles
            consumedBottles += numExchange;
            numBottles -= numExchange;

            // Exchange them for one full bottle
            numBottles++;
        }

        // Consume the remaining numBottles
        return consumedBottles + numBottles;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while (numBottles >= numExchange) {
            consumedBottles += numExchange;
            numBottles -= numExchange;
            numBottles++;
        }

        return consumedBottles + numBottles;
    }
};
```
