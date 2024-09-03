Leetcode Question: [Sum of Digits of String After Convert](https://leetcode.com/problems/sum-of-digits-of-string-after-convert/)

### Java
```java
class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        int sum = 0, num = 0;
        String str = "";
        k--;

        for(int i = 0; i < n; i++) {
            str += (s.charAt(i) - 'a' + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0');
        }
        
        while(k-- > 0) {
            num = sum;
            sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
        }

        return sum;
    }
}
```

### C++
```cpp
#include <string>
using namespace std;

class Solution {
public:
    int getLucky(string s, int k) {
        int n = s.length();
        int sum = 0, num = 0;
        string str = "";
        k--;

        for(int i = 0; i < n; i++) {
            str += to_string(s[i] - 'a' + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            sum += (str[i] - '0');
        }

        while(k-- > 0) {
            num = sum;
            sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
        }

        return sum;
    }
};
```
