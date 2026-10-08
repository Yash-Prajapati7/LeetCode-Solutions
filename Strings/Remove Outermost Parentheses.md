Leetcode Question : [Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

## Approach - 1 (Stack Based)

### Java
```java
class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        Stack<Character> st = new Stack<>();
        char c = '(';

        for (int i = 0; i < n; i++) {
            c = s.charAt(i);

            if (c == '(') {
                if (!st.isEmpty()) {
                    sb.append(c);
                }
                st.push(c);
            } else {
                if (st.size() > 1) {
                    sb.append(c);
                }
                st.pop();
            }
        }

        return new String(sb);
    }
}
```

### C++
```cpp
using namespace std;

class Solution {
public:
    string removeOuterParentheses(string s) {
        int n = s.length();
        string sb;
        sb.reserve(n);
        stack<char> st;
        char c = '(';

        for (int i = 0; i < n; i++) {
            c = s[i];

            if (c == '(') {
                if (!st.empty()) {
                    sb += c;
                }
                st.push(c);
            } else {
                if (st.size() > 1) {
                    sb += c;
                }
                st.pop();
            }
        }

        return sb;
    }
};
```

## Approach - 2 (Counter Based)

### Java
```java
class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        int st = 0;
        char c = '(';

        for (int i = 0; i < n; i++) {
            c = s.charAt(i);

            if (c == '(') {
                if (st > 0) {
                    sb.append(c);
                }
                st++;
            } else {
                st--;
                if (st > 0) {
                    sb.append(c);
                }
            }
        }

        return new String(sb);
    }
}
```

### C++
```cpp
using namespace std;

class Solution {
public:
    string removeOuterParentheses(string s) {
        int n = s.length();
        string sb;
        sb.reserve(n);
        int st = 0;
        char c = '(';

        for (int i = 0; i < n; i++) {
            c = s[i];

            if (c == '(') {
                if (st > 0) {
                    sb += c;
                }
                st++;
            } else {
                st--;
                if (st > 0) {
                    sb += c;
                }
            }
        }

        return sb;
    }
};
```
