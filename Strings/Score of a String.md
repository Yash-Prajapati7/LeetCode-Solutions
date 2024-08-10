Leetcode Question : [Score of a String](https://leetcode.com/problems/score-of-a-string/)

### Java
```java
class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs((s.charAt(i) - s.charAt(i + 1)));
        }
        return sum;
    }
}
```

### C++
```cpp
class Solution {
public:
    int scoreOfString(string s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            sum += abs(s[i] - s[i + 1]);
        }
        return sum;
    }
};
```
