Leetcode Question : [Count the Number of Special Characters II](https://leetcode.com/problems/count-the-number-of-special-characters-ii)

### Java

```java
class Solution {

    public int numberOfSpecialChars(String word) {
        int[] lastLowercaseIndex = new int[26];
        int[] firstUppercaseIndex = new int[26];

        Arrays.fill(lastLowercaseIndex, -1);
        Arrays.fill(firstUppercaseIndex, -1);

        for (int index = 0; index < word.length(); index++) {
            char currentChar = word.charAt(index);

            if (Character.isLowerCase(currentChar)) {
                lastLowercaseIndex[currentChar - 'a'] = index;
            } else {
                if (firstUppercaseIndex[currentChar - 'A'] == -1) {
                    firstUppercaseIndex[currentChar - 'A'] = index;
                }
            }
        }

        int specialCharCount = 0;

        for (int alphabetIndex = 0; alphabetIndex < 26; alphabetIndex++) {
            if (
                lastLowercaseIndex[alphabetIndex] != -1 &&
                firstUppercaseIndex[alphabetIndex] != -1 &&
                lastLowercaseIndex[alphabetIndex] < firstUppercaseIndex[alphabetIndex]
            ) {
                specialCharCount++;
            }
        }

        return specialCharCount;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numberOfSpecialChars(string word) {
        vector<int> lastLowercaseIndex(26, -1);
        vector<int> firstUppercaseIndex(26, -1);

        for (int index = 0; index < word.length(); index++) {
            char currentChar = word[index];

            if (islower(currentChar)) {
                lastLowercaseIndex[currentChar - 'a'] = index;
            } else {
                if (firstUppercaseIndex[currentChar - 'A'] == -1) {
                    firstUppercaseIndex[currentChar - 'A'] = index;
                }
            }
        }

        int specialCharCount = 0;

        for (int alphabetIndex = 0; alphabetIndex < 26; alphabetIndex++) {
            if (
                lastLowercaseIndex[alphabetIndex] != -1 &&
                firstUppercaseIndex[alphabetIndex] != -1 &&
                lastLowercaseIndex[alphabetIndex] < firstUppercaseIndex[alphabetIndex]
            ) {
                specialCharCount++;
            }
        }

        return specialCharCount;
    }
};
```
