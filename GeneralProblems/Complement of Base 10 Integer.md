Leetcode Question : [Complement of Base 10 Integer](https://leetcode.com/problems/complement-of-base-10-integer/)

## Method - 1

### Java

```java
class Solution {
    public int findComplement(int num) {
        if(num == 1) {
            return 0;
        }
        int length = Integer.toBinaryString(num).length();
        int ans = num ^ ((1 << length) - 1);
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
    int findComplement(int num) {
        if(num == 1) {
            return 0;
        }
        int length = bitset<32>(num).to_string().find('1');
        length = 32 - length;
        int ans = num ^ ((1 << length) - 1);
        return ans;
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return 0;
        }

        int i = 0;
        while(i < 32) {
            if(n < (1 << i)) {
                break;
            }
            i++;          
        }

        return n ^ ((1 << i) - 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return 0;
        }

        int i = 0;
        while(i < 32) {
            if(n < (1 << i)) {
                break;
            }
            i++;          
        }

        return n ^ ((1 << i) - 1);
    }
};
```
