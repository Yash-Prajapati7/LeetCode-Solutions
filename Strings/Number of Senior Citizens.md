Leetcode Question : [Number of Senior Citizens](https://leetcode.com/problems/number-of-senior-citizens/description/)

### Java
```java
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s : details) {
            int num = s.charAt(11) - '0';
            num = (num * 10) + s.charAt(12) - '0';
            if(num > 60) {
                count++;
            }
        }
        return count;
    }
}
```

### C++
```cpp
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int countSeniors(vector<string>& details) {
        int count = 0;
        for(const string& s : details) {
            int num = s[11] - '0';
            num = (num * 10) + (s[12] - '0');
            if(num > 60) {
                count++;
            }
        }
        return count;
    }
};
```
