## Leetcode Question: [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/description/)

### Java
```java
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlength = 0;
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            if ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
            maxlength = Math.max(maxlength, (r - l + 1));
            r++;
        }
        return maxlength;
    }
}
```

### C++
```cpp
#include <string>
#include <unordered_map>
#include <algorithm> // For max()

using namespace std;

class Solution {
public:
    int characterReplacement(string s, int k) {
        unordered_map<char, int> charCount; 
        int maxLength = 0;
        int maxFreq = 0; 
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            charCount[s[right]]++;
            maxFreq = max(maxFreq, charCount[s[right]]); // Update most frequent char count 

            // Shrink window if replacements needed exceed 'k'
            while ((right - left + 1) - maxFreq > k) { 
                charCount[s[left]]--; 
                left++; 
            }

            maxLength = max(maxLength, right - left + 1); 
        }
        
        return maxLength;
    }
};
``` 
