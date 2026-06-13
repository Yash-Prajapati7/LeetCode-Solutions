Leetcode Question : [Weighted Word Mapping](https://leetcode.com/problems/weighted-word-mapping)

### Java

```java
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        int totalWeight = 0;

        for(String word : words) {
            totalWeight = 0;
            for(int i = 0; i < word.length(); i++) {
                totalWeight += weights[word.charAt(i) - 'a'];
            }

            totalWeight %= 26;
            ans.append((char)(25 - totalWeight + 97));
        }

        return new String(ans);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        string ans = "";
        int totalWeight = 0;

        for(string& word : words) {
            totalWeight = 0;

            for(int i = 0; i < word.length(); i++) {
                totalWeight += weights[word[i] - 'a'];
            }

            totalWeight %= 26;
            ans += (char)(25 - totalWeight + 97);
        }

        return ans;
    }
};
```
