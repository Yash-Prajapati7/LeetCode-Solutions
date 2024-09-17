Leetcode Question: [Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)

### Java
```java
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str = s1.split(" ");
        HashMap<String, Integer> freq = new HashMap<>();
        for(String s : str) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        str = s2.split(" ");
        for(String s : str) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : freq.entrySet()) {
            if(entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        unordered_map<string, int> freq;
        istringstream iss(s1 + " " + s2);
        string word;
        
        while (iss >> word) {
            freq[word]++;
        }

        vector<string> result;
        for (const auto& entry : freq) {
            if (entry.second == 1) {
                result.push_back(entry.first);
            }
        }
        
        return result;
    }
};
```
