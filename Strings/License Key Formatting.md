Leetcode Question : [License Key Formatting](https://leetcode.com/problems/license-key-formatting/)

### Java
```java
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char c = 'A';
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);

            if(c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }       

            if (c != '-') {
                if(sb.length() % (k + 1) == k) sb.append('-');
                sb.append(c);
            }
        }

        return new String(sb.reverse());
    }
}
```

### C++
```cpp
class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        string result;
        char c = 'A';
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s[i];

            if (c >= 'a' && c <= 'z') {
                c = c - 32;
            }       

            if (c != '-') {
                if (result.length() % (k + 1) == k) result += '-';
                result += c;
            }
        }

        reverse(result.begin(), result.end());
        return result;
    }
};
```
