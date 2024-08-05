Leetcode Question : [Count Common Words With One Occurrence](https://leetcode.com/problems/count-common-words-with-one-occurrence/description/)
### Java
```java
public class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();
        
        for (String word : words1) {
            count1.put(word, count1.getOrDefault(word, 0) + 1);
        }
        
        for (String word : words2) {
            count2.put(word, count2.getOrDefault(word, 0) + 1);
        }
        
        int result = 0;
        for (String word : count1.keySet()) {
            if (count1.get(word) == 1 && count2.getOrDefault(word, 0) == 1) {
                result++;
            }
        }
        
        return result;
    }
}
```

### C++
```cpp
#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        unordered_map<string, int> count1;
        unordered_map<string, int> count2;
        
        for (const string& word : words1) {
            count1[word]++;
        }
        
        for (const string& word : words2) {
            count2[word]++;
        }
        
        int result = 0;
        for (const auto& pair : count1) {
            if (pair.second == 1 && count2[pair.first] == 1) {
                result++;
            }
        }
        
        return result;
    }
};
```
