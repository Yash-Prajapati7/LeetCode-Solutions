Leetcode Question : [Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)

### Java

```java
class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        int max = -1;
        for(int num : arr) {
            freq[num]++;
            max = max < num ? num : max;
        }

        for(int i = max; i >= 1; i--) {
            if(freq[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findLucky(vector<int>& arr) {
        int freq[501] = {0};
        int max = -1;
        for(int num : arr) {
            freq[num]++;
            max = max < num ? num : max;
        }

        for(int i = max; i >= 1; i--) {
            if(freq[i] == i) {
                return i;
            }
        }

        return -1;
    }
};
```
