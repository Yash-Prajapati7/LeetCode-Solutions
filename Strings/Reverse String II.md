Leetcode Question : [Reverse String II](https://leetcode.com/problems/reverse-string-ii/)

### Java
```java
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int n = s.length(), ind = 0;

        boolean reverse = true;
        for (int i = 0; i < n; i += k) {
            ind = ((i + k) <= n) ? i + k : n;
            sb.append(s.substring(i, ind));

            if (reverse) sb.reverse();
            ans.append(sb);
            sb.setLength(0);
            reverse = !reverse;
        }

        return new String(ans);
    }
}
```

### C++
```cpp
class Solution {
public:
    string reverseStr(string s, int k) {
        string ans = "";
        int n = s.length(), ind = 0;
        bool reverse = true;

        for (int i = 0; i < n; i += k) {
            ind = ((i + k) <= n) ? i + k : n;
            string temp = s.substr(i, ind - i);

            if (reverse) reverse(temp.begin(), temp.end());
            ans += temp;
            reverse = !reverse;
        }

        return ans;
    }
};
```
