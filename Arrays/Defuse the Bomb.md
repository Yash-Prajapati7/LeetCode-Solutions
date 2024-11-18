Leetcode Question: [Defuse the Bomb](https://leetcode.com/problems/defuse-the-bomb/)

### Java
```java
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if(k == 0) {
            return result;
        }

        int sum = 0;
        int s = 1, e = k;
        
        if(k < 0) {
            s = n - Math.abs(k);
            e = n - 1;
        }

        // Get the initial window sum
        for(int i = s; i <= e; i++) {
            sum += code[i];
        }

        for(int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= code[s % n];
            sum += code[(e + 1) % n];
            s++;
            e++;
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
    vector<int> decrypt(vector<int>& code, int k) {
        int n = code.size();
        vector<int> result(n, 0);
        if (k == 0) {
            return result;
        }

        int sum = 0;
        int s = 1, e = k;

        if (k < 0) {
            s = n - abs(k);
            e = n - 1;
        }

        // Get the initial window sum
        for (int i = s; i <= e; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= code[s % n];
            sum += code[(e + 1) % n];
            s++;
            e++;
        }

        return result;
    }
};
```
