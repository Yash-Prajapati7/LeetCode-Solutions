Leetcode Question : [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

### Java
```java
class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder answer = new StringBuilder(n);

        int i = n - 1;
        while (i >= 0) {
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            answer.append(s.substring(j + 1, i + 1)).append(" ");
            while (j >= 0 && s.charAt(j) == ' ') j--;
            i = j;
        }
        return answer.toString().trim();
    }
}
```

### C++
```cpp
class Solution {
public:
    string reverseWords(string s) {
        s = trim(s);
        int n = s.length();
        string answer;
        
        int i = n - 1;
        while (i >= 0) {
            int j = i;
            while (j >= 0 && s[j] != ' ') {
                j--;
            }
            answer.append(s.substr(j + 1, i - j)).append(" ");
            while (j >= 0 && s[j] == ' ') j--;
            i = j;
        }
        answer = trim(answer);
        return answer;
    }
    
private:
    string trim(const string &s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s[start] == ' ') start++;
        while (end >= start && s[end] == ' ') end--;
        return s.substr(start, end - start + 1);
    }
};

```
