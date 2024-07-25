## Leetcode Question: [Vowels of All Substrings](https://leetcode.com/problems/vowels-of-all-substrings/)

### Java
```java
class Solution {
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public long countVowels(String word) {
        long count = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (isVowel(c)) {
                // Explicitly cast both factors to long before multiplication
                count += (long)(i + 1) * (long)(n - i); 
            }
        }
        return count;
    }
}
```

### C++
```cpp
#include <string>

using namespace std;

class Solution {
public:
    bool isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    long long countVowels(string word) {
        long long count = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word[i];
            if (isVowel(c)) {
                // Explicitly cast both factors to long long before multiplication
                count += (long long)(i + 1) * (long long)(n - i);
            }
        }
        return count;
    }
};
```
## Why I did `count += (long)(i + 1) * (long)(n - i)` ?
Imagine our string is "apple" and we're currently looking at the vowel 'e' at index 4 (zero-based indexing).

**1. Substrings to the Left: (i + 1)**
   * The goal is to find all substrings that *end* at our current vowel ('e').
   * Since our vowel is at index `i`, we have `i` characters to its left: "appl".
   * We can create substrings ending at 'e' by including:
      * None of the characters to the left: "e" 
      * Just the 'l': "le"
      * 'pl': "ple"
      * 'apl': "pple"
      * All of them: "apple"
   * That's a total of 5 substrings, which is (4 + 1) or (i + 1).

**2. Substrings to the Right: (n - i)**

   * Now, we want substrings that *start* at our vowel 'e'.
   * The length of the string, `n`, is 5.
   * Characters to the right of 'e': There are none!
   * Substrings starting at 'e':
      * Only one: "e"
   * That's (5 - 4) or (n - i).
     
**Putting it Together**

* For every vowel we encounter, its contribution to the total count is the product of:
    * The number of ways to create substrings to its left.
    * The number of ways to create substrings to its right.

This lets us efficiently count vowel occurrences across all possible substrings without needing to generate each substring individually. 


