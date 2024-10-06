Leetcode Question: [Truncate Sentence](https://leetcode.com/problems/truncate-sentence/)

### Java
```java
class Solution {
    public String truncateSentence(String s, int k) {
        int spaces = 0, i = 0, n = s.length(), prev = 0;
        while(i < n && spaces < k) {
            if(s.charAt(i) == ' ') {
                spaces++;
                prev = i;
            }
            i++;
        }
        
        if(i != n) {
            return s.substring(0, prev);
        }
        return s;
    }
}
```

### C++
```cpp
class Solution {
public:
    string truncateSentence(string s, int k) {
        int spaces = 0, i = 0, n = s.length(), prev = 0;
        while(i < n && spaces < k) {
            if(s[i] == ' ') {
                spaces++;
                prev = i;
            }
            i++;
        }
        
        if(i != n) {
            return s.substr(0, prev);
        }
        return s;
    }
};
```
