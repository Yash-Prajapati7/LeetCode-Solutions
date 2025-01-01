Leetcode Question : [Sorting the Sentence](https://leetcode.com/problems/sorting-the-sentence/)

### Java
```java
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        HashMap<Integer, String> hm = new HashMap<>(9);
        int wordCount = words.length;
        int ind = 0, len = 0;

        for(String word : words) {
            len = word.length();
            ind = word.charAt(len - 1) - '0';
            word = word.substring(0, len - 1);
            hm.put(ind, word);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= wordCount; i++) {
            sb.append(hm.get(i));
            if(i != wordCount) sb.append(" ");
        }

        return new String(sb);
    }
}
```

### C++
```cpp
class Solution {
public:
    string sortSentence(string s) {
        vector<string> words;
        string word;
        stringstream ss(s);
        
        while (ss >> word) {
            words.push_back(word);
        }

        unordered_map<int, string> hm;
        int wordCount = words.size();

        for (const auto& w : words) {
            int len = w.size();
            int ind = w[len - 1] - '0';
            hm[ind] = w.substr(0, len - 1);
        }

        stringstream sb;
        for (int i = 1; i <= wordCount; ++i) {
            sb << hm[i];
            if (i != wordCount) sb << " ";
        }

        return sb.str();
    }
};
```
