Leetcode Question : [Count the Number of Computer Unlocking Permutations](https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/)

### Java

```java
class Solution {
    public int countPermutations(int[] complexity) {
        int mod = 1000000007;
        int min = complexity[0];
        int n = complexity.length;

        for(int i = 1; i < n; i++) {
            if(complexity[i] <= min) {
                return 0;
            }
        }

        long result = 1;
        for(int i = 2; i < n; i++) {
            result = (result * i) % mod;
        }

        return (int)result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countPermutations(vector<int>& complexity) {
        int mod = 1000000007;
        int minVal = complexity[0];
        int n = complexity.size();

        for(int i = 1; i < n; i++) {
            if(complexity[i] <= minVal) {
                return 0;
            }
        }

        long long result = 1;
        for(int i = 2; i < n; i++) {
            result = (result * i) % mod;
        }

        return (int) result;
    }
};
```
