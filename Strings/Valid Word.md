Leetcode Question : [Valid Word](https://leetcode.com/problems/valid-word/)

### Java

```java
class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                    hasVowel = true;
                    break;
                case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y',
                        'z',
                        'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X',
                        'Y', 'Z':
                    hasConsonant = true;
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    break;
                default:
                    return false;
            }
        }

        return hasVowel && hasConsonant;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isValid(string word) {
        int n = word.length();
        if (n < 3) return false;

        unordered_set<char> vowels = {
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
        };

        bool containsVowels = false, containsConsonant = false;

        for (int i = 0; i < n; i++) {
            char c = word[i];
            if (vowels.count(c)) {
                containsVowels = true;
            }
            else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                containsConsonant = true;
            }
            else if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        return (containsVowels && containsConsonant);
    }
};
```
