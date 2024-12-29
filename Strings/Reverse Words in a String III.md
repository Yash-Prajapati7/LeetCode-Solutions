Leetcode Question: [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)

### Java
```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int n = s.length(), j = 0;

        for (int i = 0; i < n; i = j) {
            j = i;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            sb.append(s.substring(i, j)).reverse();
            ans.append(sb);

            // Append a space only if it's not the last word
            if (j < n) {
                ans.append(" ");
            }
            
            sb.setLength(0);
            j++;
        }

        return ans.toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string word;
        string ans;
        
        while (ss >> word) {
            reverse(word.begin(), word.end());
            ans += word + " ";
        }
        
        // Remove the trailing space
        if (!ans.empty()) ans.pop_back();
        
        return ans;
    }
};
```
