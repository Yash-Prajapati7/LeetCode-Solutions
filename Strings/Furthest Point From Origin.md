Leetcode Question : [Furthest Point From Origin](https://leetcode.com/problems/furthest-point-from-origin/)

## Approach - 1 (2 Pass)

### Java

```java
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0;
        int n = moves.length();

        for(int i = 0; i < n; i++) {
            if(moves.charAt(i) == 'L') {
                l++;
            }
            else if(moves.charAt(i) == 'R') {
                r++;
            }
        }

        if(l == 0 && r == 0) {
            return n;
        }

        boolean goingLeft = l >= r;

        for(int i = 0; i < n; i++) {
            if(moves.charAt(i) == '_') {
                if(goingLeft) {
                    l++;
                    r--;
                }
                else {
                    r++;
                    l--;
                }
            }
            else if(moves.charAt(i) == 'L') {
                r--;
            }
            else {
                l--;
            }
        }

        return l > r ? l : r;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int l = 0, r = 0;
        int n = moves.length();

        for(int i = 0; i < n; i++) {
            if(moves[i] == 'L') {
                l++;
            }
            else if(moves[i] == 'R') {
                r++;
            }
        }

        if(l == 0 && r == 0) {
            return n;
        }

        bool goingLeft = l >= r;

        for(int i = 0; i < n; i++) {
            if(moves[i] == '_') {
                if(goingLeft) {
                    l++;
                    r--;
                }
                else {
                    r++;
                    l--;
                }
            }
            else if(moves[i] == 'L') {
                r--;
            }
            else {
                l--;
            }
        }

        return l > r ? l : r;
    }
};
```

---

## Approach - 2 (Single Pass)

### Java

```java
class Solution {

    public int furthestDistanceFromOrigin(String moves) {
        int L = 0;
        int R = 0;
        int B = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'R') {
                R++;
            } else {
                B++;
            }
        }
        return Math.abs(L - R) + B;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int L = 0;
        int R = 0;
        int B = 0;
        for (char c : moves) {
            if (c == 'L') {
                L++;
            } else if (c == 'R') {
                R++;
            } else {
                B++;
            }
        }
        return abs(L - R) + B;
    }
};
```
