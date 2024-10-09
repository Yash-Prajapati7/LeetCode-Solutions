Leetcode Question: [Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

### Method - 1 (Better Solution)

### Java
```java
class Solution { 
    public int minAddToMakeValid(String s) {
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == '(' && c == ')') {
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        return st.isEmpty() ? 0 : st.size();
    }
}
```

### C++
```cpp
class Solution {
public:
    int minAddToMakeValid(string s) {
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        stack<char> st;
        for(int i = 0; i < n; i++) {
            char c = s[i];
            if(!st.empty() && st.top() == '(' && c == ')') {
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        return st.empty() ? 0 : st.size();
    }
};
```

---

### Method - 2 (Optimised Solution)

### Java
```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {  // Unmatched '('
                close++;
            }
            else if(c == ')' && close > 0) {    // A matching '(' found for this ')'
                close--;
            }
            else open++;    // Unmatched ')', needs a '('
        }
        return open + close;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minAddToMakeValid(string s) {
        int open = 0, close = 0;
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        for(int i = 0; i < n; i++) {
            char c = s[i];
            if(c == '(') {  // Unmatched '('
                close++;
            }
            else if(c == ')' && close > 0) {    // A matching '(' found for this ')'
                close--;
            }
            else open++;    // Unmatched ')', needs a '('
        }
        return open + close;
    }
};
```
