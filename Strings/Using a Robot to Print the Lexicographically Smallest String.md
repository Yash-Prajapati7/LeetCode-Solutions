Leetcode Question : [Using a Robot to Print the Lexicographically Smallest String](https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string)

### Java

```java
class Solution {
    public String robotWithString(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for(char c : chars) {
            freq[c - 'a']++;
        }

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        char minChar = 'a'; // start from minimum character
        for(char c : chars) {
            st.push(c);
            freq[c - 'a']--;
            
            // skip the characters that are not present in 's'
            while(minChar != 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            while(!st.isEmpty() && st.peek() <= minChar) {
                ans.append(st.pop());
            }
        }

        return new String(ans);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string robotWithString(string s) {
        vector<int> freq(26, 0);
        for (char c : s) {
            freq[c - 'a']++;
        }

        stack<char> st;
        string ans;
        char minChar = 'a';

        for (char c : s) {
            st.push(c);
            freq[c - 'a']--;

            while (minChar != 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            while (!st.empty() && st.top() <= minChar) {
                ans += st.top();
                st.pop();
            }
        }

        return ans;
    }
};
```
