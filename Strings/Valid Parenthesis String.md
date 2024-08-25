Leetcode Question: [Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)

### Java
```java
class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                min++;
                max++;
            }
            else if(c == ')') {
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }

            if(min < 0) {
                min = 0;
            }
            if(max < 0) {
                return false;
            }
        }
        return (min == 0);
    }
}
```

### C++
```cpp
class Solution {
public:
    bool checkValidString(string s) {
        int min = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s[i];
            if(c == '(') {
                min++;
                max++;
            }
            else if(c == ')') {
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }

            if(min < 0) {
                min = 0;
            }
            if(max < 0) {
                return false;
            }
        }
        return (min == 0);
    }
};
```
