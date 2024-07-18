Leetcode Question : https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
### Java
```java
class Solution {
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        ArrayList<String> hexCode = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"));
        long n = num; 
        if(n < 0) {
            n += (1L << 32);   // Convert negative number to positive using bit-manipulation
        }
        StringBuilder hex = new StringBuilder();
        while(n > 0) {
            hex.append(hexCode.get((int)(n % 16)));
            n /= 16;
        }
        return hex.reverse().toString();
    }
}
```
### C++
```cpp
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    string toHex(int num) {
        if(num == 0) {
            return "0";
        }
        vector<string> hexCode = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        unsigned long n = static_cast<unsigned long>(num);
        if(n < 0) {
            n += (1UL << 32);   // Convert negative number to positive using bit-manipulation
        }
        string hex;
        while(n > 0) {
            hex += hexCode[n % 16];
            n /= 16;
        }
        reverse(hex.begin(), hex.end());
        return hex;
    }
};
```
