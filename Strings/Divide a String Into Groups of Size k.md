Leetcode Question : [Divide a String Into Groups of Size k](https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/)  

### Java  
```java
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        while (n % k != 0) {
            sb.append(fill);
            n++;
        }

        String[] ans = new String[n / k];
        int j = 0;
        for(int i = 0; i <= n - k; i += k) {
            ans[j] = sb.substring(i, i + k);
            j++;
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
    vector<string> divideString(string s, int k, char fill) {
        int n = s.length();
        while (n % k != 0) {
            s += fill;
            n++;
        }

        vector<string> ans(n / k);
        int j = 0;
        for(int i = 0; i <= n - k; i += k) {
            ans[j] = s.substr(i, k);
            j++;
        }

        return ans;
    }
};
```
