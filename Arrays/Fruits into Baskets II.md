Leetcode Question : [Fruits into Baskets II](https://leetcode.com/problems/fruits-into-baskets-ii/)

### Java

```java
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = fruits.length;

        for(int quantity : fruits) {
            int notPlaced = 1;
            for(int j = 0; j < n; j++) {
                if(baskets[j] >= quantity) {
                    notPlaced = 0;
                    baskets[j] = 0;
                    break;
                }
            }

            count += notPlaced;
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numOfUnplacedFruits(vector<int>& fruits, vector<int>& baskets) {
        int count = 0;
        int n = fruits.size();

        for(int quantity : fruits) {
            int notPlaced = 1;
            for(int j = 0; j < n; j++) {
                if(baskets[j] >= quantity) {
                    notPlaced = 0;
                    baskets[j] = 0;
                    break;
                }
            }

            count += notPlaced;
        }

        return count;
    }
};
```
