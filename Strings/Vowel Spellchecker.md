Leetcode Question : [Vowel Spellchecker](https://leetcode.com/problems/vowel-spellchecker/)

### Java

```java
class Solution {

    private String maskVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatchSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelErrorMap = new HashMap<>();

        for (String word : wordlist) {
            String lowerCaseWord = word.toLowerCase();
            String vowelMaskedWord = maskVowels(lowerCaseWord);

            caseInsensitiveMap.putIfAbsent(lowerCaseWord, word);
            vowelErrorMap.putIfAbsent(vowelMaskedWord, word);
        }

        int n = queries.length;
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String query = queries[i];
            
            // Rule 1: Exact match
            if (exactMatchSet.contains(query)) {
                answer[i] = query;
            } else {
                String lowerCaseQuery = query.toLowerCase();
                
                // Rule 2: Case-insensitive match
                if (caseInsensitiveMap.containsKey(lowerCaseQuery)) {
                    answer[i] = caseInsensitiveMap.get(lowerCaseQuery);
                } else {
                    String vowelMaskedQuery = maskVowels(lowerCaseQuery);
                    
                    // Rule 3: Vowel-error match
                    if (vowelErrorMap.containsKey(vowelMaskedQuery)) {
                        answer[i] = vowelErrorMap.get(vowelMaskedQuery);
                    } else {
                        // No match found
                        answer[i] = "";
                    }
                }
            }
        }
        
        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    string maskVowels(string s) {
        string result;
        for (char c : s) {
            char lower = tolower(c);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                result.push_back('*');
            } else {
                result.push_back(lower);
            }
        }
        return result;
    }

public:
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        unordered_set<string> exactMatchSet(wordlist.begin(), wordlist.end());
        unordered_map<string, string> caseInsensitiveMap;
        unordered_map<string, string> vowelErrorMap;

        for (string word : wordlist) {
            string lowerCaseWord = word;
            for (auto &c : lowerCaseWord) c = tolower(c);
            string vowelMaskedWord = maskVowels(lowerCaseWord);

            if (!caseInsensitiveMap.count(lowerCaseWord)) {
                caseInsensitiveMap[lowerCaseWord] = word;
            }
            if (!vowelErrorMap.count(vowelMaskedWord)) {
                vowelErrorMap[vowelMaskedWord] = word;
            }
        }

        int n = queries.size();
        vector<string> answer(n);

        for (int i = 0; i < n; i++) {
            string query = queries[i];
            
            // Rule 1: Exact match
            if (exactMatchSet.count(query)) {
                answer[i] = query;
            } else {
                string lowerCaseQuery = query;
                for (auto &c : lowerCaseQuery) c = tolower(c);
                
                // Rule 2: Case-insensitive match
                if (caseInsensitiveMap.count(lowerCaseQuery)) {
                    answer[i] = caseInsensitiveMap[lowerCaseQuery];
                } else {
                    string vowelMaskedQuery = maskVowels(lowerCaseQuery);
                    
                    // Rule 3: Vowel-error match
                    if (vowelErrorMap.count(vowelMaskedQuery)) {
                        answer[i] = vowelErrorMap[vowelMaskedQuery];
                    } else {
                        // No match found
                        answer[i] = "";
                    }
                }
            }
        }
        
        return answer;
    }
};
```
