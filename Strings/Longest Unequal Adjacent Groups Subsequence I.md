Leetcode Question : [Longest Unequal Adjacent Groups Subsequence I](https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/)

### Java

```java
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i = 1; i < groups.length; i++) {
            if(groups[i] != groups[i - 1]) ans.add(words[i]);
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
    vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
        vector<string> ans;
        ans.push_back(words[0]);
        for(int i = 1; i < groups.size(); i++) {
            if(groups[i] != groups[i - 1]) ans.push_back(words[i]);
        }
        return ans;
    }
};
```
