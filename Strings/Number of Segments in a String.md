Leetcode Question : [Number of Segments in a String](https://leetcode.com/problems/number-of-segments-in-a-string/)

### Java
```java
class Solution {
    public int countSegments(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;

        int words = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                words++;
            }
        }

        return ++words;
    }
}
```

### C++
```cpp
class Solution {
public:
    int countSegments(string s) {
        s = trim(s);
        int n = s.length();
        if (n == 0) return 0;

        int words = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ' && s[i - 1] != ' ') {
                words++;
            }
        }

        return ++words;
    }
};
```
