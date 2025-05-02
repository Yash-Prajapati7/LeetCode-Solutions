Leetcode Question : [Push Dominoes](https://leetcode.com/problems/push-dominoes/)

### Java

```java
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        if(n == 1) return dominoes;
        char[] dominos = dominoes.toCharArray();
        int[] forces = new int[n];

        int force = 0;
        for(int i = 0; i < n; i++) {
            if (dominos[i] == 'R') force = n;
            else if (dominos[i] == 'L') force = 0;
            else {
                if (force > 0) force -= 1;
            }
            forces[i] = force;
        }

        force = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(dominos[i] == 'L') force = n;
            else if (dominos[i] == 'R') force = 0;
            else {
                if (force > 0) force -= 1;
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder(n);
        for(int f : forces) {
            if(f > 0) sb.append('R');
            else if(f < 0) sb.append('L');
            else sb.append('.');
        }

        return new String(sb);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.length();
        if(n == 1) return dominoes;
        vector<char> dominos(dominoes.begin(), dominoes.end());
        vector<int> forces(n, 0);

        int force = 0;
        for(int i = 0; i < n; i++) {
            if (dominos[i] == 'R') force = n;
            else if (dominos[i] == 'L') force = 0;
            else force = (force - 1) < 0 ? 0 : force - 1;
            forces[i] = force;
        }

        force = 0;
        for(int i = n - 1; i >= 0; i--) {
            if (dominos[i] == 'L') force = n;
            else if (dominos[i] == 'R') force = 0;
            else force = (force - 1) < 0 ? 0 : force - 1;
            forces[i] -= force;
        }

        string result;
        for(int f : forces) {
            if(f > 0) result += 'R';
            else if(f < 0) result += 'L';
            else result += '.';
        }

        return result;
    }
};
```
