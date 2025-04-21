Leetcode Question : [Count the Hidden Sequences](https://leetcode.com/problems/count-the-hidden-sequences/)

### Java
```java
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0, max = 0, current = 0;
        int diff = upper - lower;

        for(int d : differences) {
            current += d;
            min = min > current ? current : min;
            max = max < current ? current : max;
            if(max - min > diff) return 0;
        }

        return (diff + 1) - (max - min);
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        int minVal = 0, maxVal = 0, current = 0;
        int diff = upper - lower;

        for(int d : differences) {
            current += d;
            minVal = min(minVal, current);
            maxVal = max(maxVal, current);
            if(maxVal - minVal > diff) return 0;
        }

        return (diff + 1) - (maxVal - minVal);
    }
};
```
