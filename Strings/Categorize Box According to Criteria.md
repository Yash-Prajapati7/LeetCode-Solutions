Leetcode Question : [Categorize Box According to Criteria](https://leetcode.com/problems/categorize-box-according-to-criteria/description/)

### Java
```java
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        
        boolean bulky = length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000;
        boolean heavy = mass >= 100;
        
        if(bulky && heavy) {
            return "Both";
        } else if(bulky) {
            return "Bulky";
        } else if(heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
```

### C++
```cpp
#include <string>

using namespace std;

class Solution {
public:
    string categorizeBox(int length, int width, int height, int mass) {
        long long volume = static_cast<long long>(length) * width * height;
        
        bool bulky = length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000;
        bool heavy = mass >= 100;
        
        if(bulky && heavy) {
            return "Both";
        } else if(bulky) {
            return "Bulky";
        } else if(heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
};
```
