Leetcode Question : [Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/)

### Java
```java
class Solution {
    private int gcd(int length1, int length2) {
        if(length2 == 0) {
            return length1;
        }
        return gcd(length2, length1 % length2);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
}
```

### C++
```cpp
#include <string>
using namespace std;

class Solution {
private:
    int gcd(int length1, int length2) {
        if (length2 == 0) {
            return length1;
        }
        return gcd(length2, length1 % length2);
    }
    
public:
    string gcdOfStrings(string str1, string str2) {
        if ((str1 + str2) != (str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substr(0, gcdLength);
    }
};
```
