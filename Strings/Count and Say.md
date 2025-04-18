Leetcode Question : [Count and Say](https://leetcode.com/problems/count-and-say/)

### Java
```java
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String result = "1";
        StringBuilder sb;

        for(int i = 1; i < n; i++) {
            sb = new StringBuilder();
            int count = 1;
            int m = result.length();
            
            for(int j = 1; j < m; j++) {
                if(result.charAt(j) == result.charAt(j - 1)) count++;
                else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;  // reset the count
                }
            }

            sb.append(count).append(result.charAt(m - 1));
            result = new String(sb);
        }

        return result;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if(n == 1) return "1";
        string result = "1";
        stringstream ss;

        for(int i = 1; i < n; i++) {
            ss.str("");
            ss.clear();
            int count = 1;
            int m = result.length();

            for(int j = 1; j < m; j++) {
                if(result[j] == result[j - 1]) count++;
                else {
                    ss << count << result[j - 1];
                    count = 1;
                }
            }

            ss << count << result[m - 1];
            result = ss.str();
        }

        return result;
    }
};
```
