Leetcode Question : [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

### Java

```java
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int currentLength = 0, maxLength = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);    // boundary index

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    currentLength = i - st.peek();
                    maxLength = maxLength < currentLength ? currentLength : maxLength;
                }
            }
        }

        return maxLength;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int currentLength = 0, maxLength = 0;
        stack<int> st;
        st.push(-1);    // boundary index

        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.empty()) {
                    st.push(i);
                } else {
                    currentLength = i - st.top();
                    maxLength = maxLength < currentLength ? currentLength : maxLength;
                }
            }
        }

        return maxLength;
    }
};
```
