Leetcode Question : [Maximum Odd Binary Number](https://leetcode.com/problems/maximum-odd-binary-number/)

### Java
```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int numberOfOnes = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' == 1) {
                numberOfOnes++;
            }
        }
        
        for(int i = 0; i < s.length() - 1; i++) {
            if(numberOfOnes-- > 1) {
                str.append("1");
            } else {
                str.append("0");
            }
            
        }
        str.append("1");
        return str.toString();
    }
}
```

### C++
```cpp
#include <string>
using namespace std;

class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int numberOfOnes = 0;
        string str;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] - '0' == 1) {
                numberOfOnes++;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (numberOfOnes-- > 1) {
                str += "1";
            } else {
                str += "0";
            }
        }
        str += "1";
        return str;
    }
};
```
