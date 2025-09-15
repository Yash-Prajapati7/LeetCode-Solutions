Leetcode Question : [Maximum Number of Words You Can Type](https://leetcode.com/problems/maximum-number-of-words-you-can-type)

### Java

```java
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        boolean[] broken = new boolean[26];
        for(int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }

        int possible = words.length;

        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                if(broken[word.charAt(i) - 'a']) {
                    possible--;
                    break;
                }
            }
        }

        return possible;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        vector<string> words;
        stringstream ss(text);
        string word;
        while (ss >> word) {
            words.push_back(word);
        }

        vector<bool> broken(26, false);
        for (char c : brokenLetters) {
            broken[c - 'a'] = true;
        }

        int possible = words.size();

        for (string &word : words) {
            for (char c : word) {
                if (broken[c - 'a']) {
                    possible--;
                    break;
                }
            }
        }

        return possible;
    }
};
```
