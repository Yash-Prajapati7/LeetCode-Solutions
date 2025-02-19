Leetcode Question : [The K-th Lexicographical String of All Happy Strings of Length n](https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/)  

### Java
```java
class Solution {
    int index = 0;

    private String getHappyString(int n, int k, StringBuilder current) {
        int len = current.length();
        if(len == n) {
            index++;
            if(index == k) return new String(current);
            return "";
        }
        String result = "";

        for(char ch = 'a'; ch <= 'c'; ch++) {
            if(len > 0 && current.charAt(len - 1) == ch) {
                continue;
            }

            current.append(ch);
            result = getHappyString(n, k, current);

            if(!result.isEmpty()) {
                return result;
            }
            current.setLength(len);
        }

        return "";
    }

    public String getHappyString(int n, int k) {
        if(k > (3 * (1 << (n - 1)))) return ""; // at max there can only exist [ 3 * 2^(n-1) ] strings for a given 'n'

        StringBuilder current = new StringBuilder("");
        return getHappyString(n, k, current);   
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    int index = 0;

    string getHappyString(int n, int k, string &current) {
        int len = current.length();
        if(len == n) {
            index++;
            if(index == k) return current;
            return "";
        }
        string result = "";

        for(char ch = 'a'; ch <= 'c'; ch++) {
            if(len > 0 && current[len - 1] == ch) {
                continue;
            }

            current.push_back(ch);
            result = getHappyString(n, k, current);

            if(!result.empty()) {
                return result;
            }
            current.pop_back();
        }

        return "";
    }

public:
    string getHappyString(int n, int k) {
        if(k > (3 * (1 << (n - 1)))) return ""; // at max there can only exist [ 3 * 2^(n-1) ] strings for a given 'n'

        string current = "";
        return getHappyString(n, k, current);
    }
};
```
