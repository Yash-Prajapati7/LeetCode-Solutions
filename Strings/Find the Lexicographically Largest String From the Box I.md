Leetcode Question : [Find the Lexicographically Largest String From the Box I](https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        String res = "";

        for(int i = 0; i < n; i++) {
            int end = i + n - numFriends + 1;
            end = end > n ? n : end;
            String s = word.substring(i, end);
            if(res.compareTo(s) <= 0) res = s;
        }

        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string answerString(string word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        string res = "";

        for(int i = 0; i < n; i++) {
            int end = i + n - numFriends + 1;
            end = end > n ? n : end;
            string s = word.substr(i, end - i);
            if(res <= s) res = s;
        }

        return res;
    }
};
```

## Method - 2 (Optimised)
- Explaination : Here we just find the lexicographically largest substring & than return the substring that is within our range (i.e n - numFriends + 1)
### Java

```java
class Solution {

    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int temp = i;
                i = j;
                j = Math.max(j + 1, temp + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string lastSubstring(string s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s[i + k] == s[j + k]) {
                k++;
            }
            if (j + k < n && s[i + k] < s[j + k]) {
                int temp = i;
                i = j;
                j = max(j + 1, temp + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substr(i);
    }

    string answerString(string word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        string last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substr(0, min(m, n - numFriends + 1));
    }
};
```
