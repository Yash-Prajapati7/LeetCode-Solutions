Leetcode Question : [Minimum Index Sum of Two Lists](https://leetcode.com/problems/minimum-index-sum-of-two-lists/)

### Java

```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        String word = "";
        for(int i = 0; i < list1.length; i++) {
            word = list1[i].strip();
            if(word.length() > 0) {
                map.put(word, i);
            }
        }

        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE, idx = -1;

        for(int j = 0; j < list2.length; j++) {
            word = list2[j].strip();
            if(map.containsKey(word)) {
                idx = map.get(word);
                if(min == (idx + j)) {
                    ans.add(word);
                }
                else if(min > (idx + j)) {
                    ans.clear();
                    min = (idx + j);
                    ans.add(word);
                }
            }
        }

        String[] result = new String[ans.size()];
        int k = 0;
        for(String s : ans) {
            result[k++] = s;
        }
        
        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        unordered_map<string, int> map;
        string word = "";
        for(int i = 0; i < list1.size(); i++) {
            word = list1[i];
            if(word.length() > 0) {
                map[word] = i;
            }
        }

        vector<string> ans;
        int minSum = INT_MAX, idx = -1;

        for(int j = 0; j < list2.size(); j++) {
            word = list2[j];
            if(map.find(word) != map.end()) {
                idx = map[word];
                if(minSum == (idx + j)) {
                    ans.push_back(word);
                } else if(minSum > (idx + j)) {
                    ans.clear();
                    minSum = idx + j;
                    ans.push_back(word);
                }
            }
        }

        return ans;
    }
};
```
