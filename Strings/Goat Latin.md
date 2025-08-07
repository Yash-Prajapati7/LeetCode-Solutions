Leetcode Question : [Goat Latin](https://leetcode.com/problems/goat-latin)

### Java

```java
class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();

            char firstChar = words[i].charAt(0);
            if (vowels.indexOf(firstChar) != -1) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1)).append(firstChar);
            }

            sb.append("ma");

            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }

            result.append(sb).append(" ");
        }

        return result.toString().trim();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string toGoatLatin(string sentence) {
        istringstream iss(sentence);
        string word, result, vowels = "aeiouAEIOU";
        int index = 1;

        while (iss >> word) {
            if (vowels.find(word[0]) != string::npos) {
                result += word;
            } else {
                result += word.substr(1) + word[0];
            }

            result += "ma" + string(index, 'a') + " ";
            index++;
        }

        if (!result.empty()) result.pop_back(); // Remove trailing space
        return result;
    }
};
```
