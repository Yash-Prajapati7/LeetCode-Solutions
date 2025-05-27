Leetcode Question : [Divisible and Non-Divisible Sums Difference](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/)

## Method - 1 (Iterative)

### Java

```java
class Solution {
    public int differenceOfSums(int n, int m) {
        if(m == 1) return -((n * (n + 1)) >> 1);
        else if(m > n) return (n * (n + 1)) >> 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int differenceOfSums(int n, int m) {
        if(m == 1) return -((n * (n + 1)) >> 1);
        else if(m > n) return (n * (n + 1)) >> 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
};
```

## Method - 2 (Formula)

### Java

```java
class Solution {
    public int differenceOfSums(int n, int m) {
        int k = n / m;
        return ((n * (n + 1)) >> 1) - (k * (k + 1) * m);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int differenceOfSums(int n, int m) {
        int k = n / m;
        return ((n * (n + 1)) >> 1) - (k * (k + 1) * m);
    }
};
```
