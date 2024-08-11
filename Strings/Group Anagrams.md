Leetcode Question : [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

### Java
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        return new ArrayList<>(hm.values());
    }
}
```

### C++
```cpp

#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if(strs.empty()) {
            return {};
        }
        unordered_map<string, vector<string>> hm;

        for(const string& s : strs) {
            string key = s;
            sort(key.begin(), key.end());
            hm[key].push_back(s);
        }

        vector<vector<string>> result;
        for(auto& [key, group] : hm) {
            result.push_back(group);
        }

        return result;
    }
};
```
