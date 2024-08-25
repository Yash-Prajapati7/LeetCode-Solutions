Leetcode Question: [Split a String in Balanced Strings](https://leetcode.com/problems/split-a-string-in-balanced-strings/)

### Java
```java
class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') {
                balance++;
            }
            else {
                balance--;
            }
            if(balance == 0) {
                count++;
            }
        }
        return count;
    }
}
```

### C++
```cpp
class Solution {
public:
    int balancedStringSplit(string s) {
        int balance = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == 'L') {
                balance++;
            }
            else {
                balance--;
            }
            if(balance == 0) {
                count++;
            }
        }
        return count;
    }
};
```
