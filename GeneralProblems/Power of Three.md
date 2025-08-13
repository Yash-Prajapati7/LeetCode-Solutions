Leetcode Question : [Power of Three](https://leetcode.com/problems/power-of-three/)

## Method - 1

### Java

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }

        int num = 1;
        while(num < Integer.MAX_VALUE / 3) {
            if(num == n) {
                return true;
            }
            else if(n % 2 == 0) {
                return false;
            }
            else {
                num *= 3;
            }
        }
        
        if(num == n) return true;
        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }

        int num = 1;
        while(num < INT_MAX / 3) {
            if(num == n) {
                return true;
            }
            else if(n % 2 == 0) {
                return false;
            }
            else {
                num *= 3;
            }
        }
        
        if(num == n) return true;
        return false;
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return 1162261467 % n == 0; 
        // 1162261467 is the largest integer power of 3
        // so if n can perfectly divide it than n is a power of 3
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n <= 0) return false;
        return 1162261467 % n == 0; 
        // 1162261467 is the largest integer power of 3
        // so if n can perfectly divide it then n is a power of 3
    }
};
```
