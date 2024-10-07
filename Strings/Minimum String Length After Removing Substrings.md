Leetcode Question : [Minimum String Length After Removing Substrings](https://leetcode.com/problems/minimum-string-length-after-removing-substrings/)

### Java
```java
class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
      
        while(i < n) {
            char c = s.charAt(i);
            if(!st.isEmpty() && ((c == 'B' && st.peek() == 'A') || (c == 'D' && st.peek() == 'C'))) {
                st.pop();
            }
            else {
                st.push(c);
            }
            i++;            
        }
        return st.isEmpty() ? 0 : st.size();
    }
}
```

### C++
```cpp
class Solution {
public:
    int minLength(string s) {
        stack<char> st;
        int i = 0;
        int n = s.length();
        
        while(i < n) {
            char c = s[i];
            if(!st.empty() && ((c == 'B' && st.top() == 'A') || (c == 'D' && st.top() == 'C'))) {
                st.pop();
            }
            else {
                st.push(c);
            }
            i++;
        }
        return st.empty() ? 0 : st.size();
    }
};
```
