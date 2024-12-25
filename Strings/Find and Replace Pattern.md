Leetcode Question: [Find and Replace Pattern](https://leetcode.com/problems/find-and-replace-pattern/)

### Java
```java
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> ans = new ArrayList<>();
        
        for (String word : words) {
            boolean correct = true;
            char[] chars = word.toCharArray();
            if (n != chars.length) continue;
            
            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> seenChars = new HashSet<>();
            int i = 0;
            
            while (i < n) {
                char c = pattern.charAt(i);
                char w = chars[i];
                
                if (map.containsKey(c)) {
                    if (!map.get(c).equals(w)) {
                        correct = false;
                        break;
                    }
                } else {
                    if (seenChars.contains(w)) {
                        correct = false;
                        break;
                    }
                    seenChars.add(w);
                    map.put(c, w);
                }
                i++;
            }
            
            if (correct) {
                ans.add(word);
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
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        int n = pattern.length();
        vector<string> ans;
        
        for (string& word : words) {
            bool correct = true;
            vector<char> chars(word.begin(), word.end());
            if (n != chars.size()) continue;
            
            unordered_map<char, char> map;
            unordered_set<char> seenChars;
            int i = 0;
            
            while (i < n) {
                char c = pattern[i];
                char w = chars[i];
                
                if (map.find(c) != map.end()) {
                    if (map[c] != w) {
                        correct = false;
                        break;
                    }
                } else {
                    if (seenChars.find(w) != seenChars.end()) {
                        correct = false;
                        break;
                    }
                    seenChars.insert(w);
                    map[c] = w;
                }
                i++;
            }
            
            if (correct) {
                ans.push_back(word);
            }
        }
        
        return ans;
    }
};
```
