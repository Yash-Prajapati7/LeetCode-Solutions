Leetcode Question : [Apple Redistribution Into Boxes](https://leetcode.com/problems/apple-redistribution-into-boxes/)

### Java

```java
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for(int basket : apple) {
            sum += basket;
        }

        int result = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            if(sum > 0) {
                sum -= capacity[i];
                result++;
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        sort(capacity.begin(), capacity.end());
        int sum = 0;
        for (int basket : apple) {
            sum += basket;
        }

        int result = 0;

        for (int i = capacity.size() - 1; i >= 0; i--) {
            if (sum > 0) {
                sum -= capacity[i];
                result++;
            }
        }

        return result;
    }
};
```
