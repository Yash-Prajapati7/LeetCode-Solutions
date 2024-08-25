Leetcode Question: [Split Strings by Separator](https://leetcode.com/problems/split-strings-by-separator/)

### Java
```java
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String temp = "";
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(c == separator && temp != "") {
                    ans.add(temp);
                    temp = "";
                }
                if(c != separator) {
                    temp += c;
                }
            }
            if(temp != "") {
                ans.add(temp);
            }
        }
        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<string> splitWordsBySeparator(vector<string>& words, char separator) {
        vector<string> ans;
        for(int i = 0; i < words.size(); i++) {
            string word = words[i];
            string temp = "";
            for(int j = 0; j < word.length(); j++) {
                char c = word[j];
                if(c == separator && temp != "") {
                    ans.push_back(temp);
                    temp = "";
                }
                if(c != separator) {
                    temp += c;
                }
            }
            if(temp != "") {
                ans.push_back(temp);
            }
        }
        return ans;
    }
};
```
