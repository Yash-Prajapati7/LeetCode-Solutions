Leetcode Question : [Longest Palindrome by Concatenating Two Letter Words](https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words)

### Java

```java
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int len = 0, alreadyPalindrome = 0;
        for (String key : freq.keySet()) {
            int f = freq.get(key);
            String reversed = new StringBuilder(key).reverse().toString();

            if (key.charAt(0) == key.charAt(1)) {
                len += (f / 2) * 4; // make pairs
                if (f % 2 == 1) {
                    alreadyPalindrome = 1; // one can be placed in the center
                }
            } else if (freq.containsKey(reversed) && key.compareTo(reversed) < 0) {
                int revFreq = freq.get(reversed);
                len += Math.min(f, revFreq) * 4; // count only once
            }
        }

        return len + (alreadyPalindrome * 2);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        unordered_map<string, int> freq;
        for (string& word : words) {
            freq[word]++;
        }

        int len = 0, alreadyPalindrome = 0;
        for (auto& [key, f] : freq) {
            string reversed = key;
            reverse(reversed.begin(), reversed.end());

            if (key[0] == key[1]) {
                len += (f / 2) * 4;
                if (f % 2 == 1) {
                    alreadyPalindrome = 1;
                }
            } else if (freq.count(reversed) && key < reversed) {
                int revFreq = freq[reversed];
                len += min(f, revFreq) * 4;
            }
        }

        return len + (alreadyPalindrome * 2);
    }
};
```
