Leetcode Question : [Largest 3-Same-Digit Number in String](https://leetcode.com/problems/largest-3-same-digit-number-in-string/)

### Java

```java
class Solution {
    public String largestGoodInteger(String num) {
        String maxTriplet = "";
        
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triplet = num.substring(i, i + 3);
                if (maxTriplet.isEmpty() || triplet.compareTo(maxTriplet) > 0) {
                    maxTriplet = triplet;
                    if (maxTriplet.equals("999")) return "999"; // early exit
                }
            }
        }
        
        return maxTriplet;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string largestGoodInteger(string num) {
        string maxTriplet = "";
        
        for (int i = 0; i < num.size() - 2; i++) {
            if (num[i] == num[i + 1] && num[i] == num[i + 2]) {
                string triplet = num.substr(i, 3);
                if (maxTriplet.empty() || triplet > maxTriplet) {
                    maxTriplet = triplet;
                    if (maxTriplet == "999") return "999"; // early exit
                }
            }
        }
        
        return maxTriplet;
    }
};
```
