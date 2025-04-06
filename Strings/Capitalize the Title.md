Leetcode Question : [Capitalize the Title](https://leetcode.com/problems/capitalize-the-title/)
 
### Java  
```java
class Solution {
    public String capitalizeTitle(String title) {
        int n = title.length();
        if (n <= 2) return title.toLowerCase();
        String[] words = title.split(" ");
        
        for (int k = 0; k < words.length; k++) {
            String word = words[k];
            if (word.length() > 2) {
                char[] chars = word.toCharArray();
                chars[0] = chars[0] >= 'a' ? (char)(chars[0] - 32) : chars[0];
                for (int i = 1; i < chars.length; i++) {
                    chars[i] = chars[i] <= 'Z' ? (char)(chars[i] + 32) : chars[i];
                }
                words[k] = new String(chars);
            } else {
                words[k] = word.toLowerCase();
            }
        }
        
        StringBuilder sb = new StringBuilder(n + 2);
        for (String word : words) {
            sb.append(word).append(" ");
        }
        sb.setLength(n);

        return new String(sb);
    }
}
```

### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string capitalizeTitle(string title) {
        int n = title.length();
        if (n <= 2) {
            transform(title.begin(), title.end(), title.begin(), ::tolower);
            return title;
        }

        vector<string> words;
        int i = 0;
        while (i < n) {
            while (i < n && title[i] == ' ') i++;
            int start = i;
            while (i < n && title[i] != ' ') i++;
            if (start < i) words.push_back(title.substr(start, i - start));
        }

        for (int k = 0; k < words.size(); k++) {
            string& word = words[k];
            if (word.length() > 2) {
                if (word[0] >= 'a') word[0] = word[0] - 32;
                for (int i = 1; i < word.size(); i++) {
                    if (word[i] <= 'Z') word[i] = word[i] + 32;
                }
            } else {
                transform(word.begin(), word.end(), word.begin(), ::tolower);
            }
        }

        string result;
        for (int k = 0; k < words.size(); k++) {
            result += words[k];
            if (k != words.size() - 1) result += ' ';
        }

        return result;
    }
};

```
