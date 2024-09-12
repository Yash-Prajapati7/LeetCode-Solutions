Leetcode Question: [Count the Number of Consistent Strings](https://leetcode.com/problems/count-the-number-of-consistent-strings/)

### Java
```java
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < allowed.length(); i++) {
            hs.add(allowed.charAt(i));
        } 

        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean consistent = true;
            
            for(int j = 0; j < s.length(); j++) {
                if(!hs.contains(s.charAt(j))) {
                    consistent = false;
                }
            }
            if(consistent) {
                ans++;
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
    int countConsistentStrings(string allowed, vector<string>& words) {
        unordered_set<char> hs;
        int ans = 0;
        for(int i = 0; i < allowed.length(); i++) {
            hs.insert(allowed[i]);
        }

        for(int i = 0; i < words.size(); i++) {
            string s = words[i];
            bool consistent = true;
            
            for(int j = 0; j < s.length(); j++) {
                if(hs.find(s[j]) == hs.end()) {
                    consistent = false;
                }
            }
            if(consistent) {
                ans++;
            }
        }
        return ans;
    }
};
```
