Leetcode Question : [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)

### Java

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder(26);
        char currentCharacter = 'a';

        for (int i = 0; i < s.length(); i++) {
            currentCharacter = s.charAt(i);

            // One occurrence has now been processed
            freq[currentCharacter - 'a']--;

            // Skip if already present in the subsequence
            if (seen[currentCharacter - 'a']) {
                continue;
            }

            while (sb.length() > 0
                    && sb.charAt(sb.length() - 1) > currentCharacter
                    && freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                seen[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.setLength(sb.length() - 1);
            }

            sb.append(currentCharacter);
            seen[currentCharacter - 'a'] = true;
        }

        return sb.toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<bool> seen(26, false);
        vector<int> freq(26, 0);

        for (char c : s) {
            freq[c - 'a']++;
        }

        string result;
        char currentCharacter = 'a';

        for (char c : s) {
            currentCharacter = c;

            // One occurrence has now been processed
            freq[currentCharacter - 'a']--;

            // Skip if already present in the subsequence
            if (seen[currentCharacter - 'a']) {
                continue;
            }

            while (!result.empty()
                   && result.back() > currentCharacter
                   && freq[result.back() - 'a'] > 0) {

                seen[result.back() - 'a'] = false;
                result.pop_back();
            }

            result.push_back(currentCharacter);
            seen[currentCharacter - 'a'] = true;
        }

        return result;
    }
};
```
