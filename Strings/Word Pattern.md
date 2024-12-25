Leetcode Question : [Word Pattern](https://leetcode.com/problems/word-pattern/)

### Java
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        HashSet<String> seenWords = new HashSet<>(words.length);
        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(w)) return false;
            }
            else {
                if(seenWords.contains(w)) return false;
                seenWords.add(w);
                map.put(c, w);
            }
        }       
        return true;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool wordPattern(string pattern, string s) {
        vector<string> words;
        stringstream ss(s);
        string word;
        while (ss >> word) words.push_back(word);

        if (pattern.size() != words.size()) return false;

        unordered_set<string> seenWords;
        unordered_map<char, string> map;

        for (int i = 0; i < pattern.size(); i++) {
            char c = pattern[i];
            string w = words[i];
            if (map.count(c)) {
                if (map[c] != w) return false;
            } else {
                if (seenWords.count(w)) return false;
                seenWords.insert(w);
                map[c] = w;
            }
        }
        return true;
    }
};
```
