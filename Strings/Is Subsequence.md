Leetcode Question: [Is Subsequence](https://leetcode.com/problems/is-subsequence/)

### Java
```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n < m) {
            return false;
        }
        else if(m == 0) {
            return true;
        }
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }
}
```

### C++
```cpp
class Solution {
public:
    bool isSubsequence(string s, string t) {
        int m = s.length();
        int n = t.length();
        if (n < m) {
            return false;
        } else if (m == 0) {
            return true;
        }

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }

        return i == m;
    }
};
```
