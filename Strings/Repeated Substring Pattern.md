Leetcode Question: [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)

### Java
```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String modified = doubled.substring(1, doubled.length() - 1);
        return modified.contains(s);
    }
}
```

### C++
```cpp
class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        string doubled = s + s;
        string modified = doubled.substr(1, doubled.length() - 2);
        return modified.find(s) != string::npos;
    }
};
```
