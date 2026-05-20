Leetcode Question : [Occurrences After Bigram](https://leetcode.com/problems/occurrences-after-bigram)

### Java

```java
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1]))
                ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> findOcurrences(string text, string first, string second) {
        stringstream ss(text);
        vector<string> words;
        string word;

        while (ss >> word) {
            words.push_back(word);
        }

        vector<string> ans;

        for (int i = 2; i < words.size(); ++i) {
            if (first == words[i - 2] && second == words[i - 1]) {
                ans.push_back(words[i]);
            }
        }

        return ans;
    }
};
```
