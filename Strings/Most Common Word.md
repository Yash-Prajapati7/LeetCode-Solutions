Leetcode Question : [Most Common Word](https://leetcode.com/problems/most-common-word)

### Java

```java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {

        unordered_set<string> bannedWords;
        for (string word : banned)
            bannedWords.insert(word);

        string ans = "";
        int maxCount = 0;
        unordered_map<string, int> wordCount;
        string wordBuffer = "";
        vector<char> chars(paragraph.begin(), paragraph.end());

        for (int p = 0; p < chars.size(); ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (isalpha(currChar)) {
                wordBuffer += tolower(currChar);
                if (p != chars.size() - 1)
                    continue;
            }

            // 2). at the end of one word or at the end of paragraph
            if (!wordBuffer.empty()) {
                string word = wordBuffer;
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.count(word)) {
                    int newCount = ++wordCount[word];
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = "";
            }
        }
        return ans;
    }
};
```
