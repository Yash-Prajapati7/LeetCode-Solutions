Leetcode Question : [Reverse Substrings Between Each Pair of Parentheses](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)

### Java

```java
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] paranthesisPairs = new int[n];
        Stack<Integer> openParanthesisIndex = new Stack<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openParanthesisIndex.push(i);
            } else if (s.charAt(i) == ')') {
                idx = openParanthesisIndex.pop();
                paranthesisPairs[idx] = i;
                paranthesisPairs[i] = idx;
            }
        }

        StringBuilder result = new StringBuilder(n);
        int direction = 1;
        char c = 'a';

        for (int i = 0; i >= 0 && i < n; i += direction) {
            c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result.append(c);
            } else {
                i = paranthesisPairs[i];
                direction = -direction;
            }
        }

        return new String(result);
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.length();
        vector<int> paranthesisPairs(n);
        stack<int> openParanthesisIndex;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                openParanthesisIndex.push(i);
            } else if (s[i] == ')') {
                idx = openParanthesisIndex.top();
                openParanthesisIndex.pop();

                paranthesisPairs[idx] = i;
                paranthesisPairs[i] = idx;
            }
        }

        string result;
        result.reserve(n);

        int direction = 1;
        char c = 'a';

        for (int i = 0; i >= 0 && i < n; i += direction) {
            c = s[i];

            if (c >= 'a' && c <= 'z') {
                result += c;
            } else {
                i = paranthesisPairs[i];
                direction = -direction;
            }
        }

        return result;
    }
};
```
