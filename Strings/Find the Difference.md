Leetcode Question: [Find the Difference](https://leetcode.com/problems/find-the-difference/)

### Java
```java
class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) {
            return t.charAt(0);
        }

        int total = 0;
        for(int i = 0; i < t.length(); i++) {
            total += (int)(t.charAt(i));
        }

        for(int i = 0; i < s.length(); i++) {
            total -= (int)(s.charAt(i));
        }

        return (char)(total);
    }
}
```

### C++
```cpp
class Solution {
public:
    char findTheDifference(string s, string t) {
        if(s.length() == 0) {
            return t[0];
        }

        int total = 0;
        for(int i = 0; i < t.length(); i++) {
            total += (int)(t[i]);
        }

        for(int i = 0; i < s.length(); i++) {
            total -= (int)(s[i]);
        }

        return (char)(total);
    }
};
```

- Note : If the max length constraint for 's' is large, you can do `total += t.charAt(i) - 'a'` and perform the same operations & return `total + 'a'`. So that total does not cross the Integer limit 
