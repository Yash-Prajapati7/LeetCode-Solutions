Leetcode Question : [Find Resultant Array After Removing Anagrams](https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/)

## Method - 1

### Java

```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        Set<String> seen = new HashSet<>(100);
        List<String> result = new ArrayList<>(n);

        int i = 0;
        while (i < n) {
            String word = words[i];
            result.add(word);

            int[] freq = new int[26];
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;
            }

            int k = i + 1;
            while (k < n) {
                boolean breakDetected = false;
          
                if(words[k].length() != words[i].length()) {
                    break;
                }

                String next = words[k];
                int[] nextFreq = new int[26];
                for (int j = 0; j < word.length(); j++) {
                    nextFreq[next.charAt(j) - 'a']++;
                }

                for(int l = 0; l < 26; l++) {
                    if(freq[l] != nextFreq[l]) {
                        breakDetected = true;
                        break;
                    }
                }

                if(breakDetected) {
                    break;
                }

                k++;
            }

            i = k;
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
    vector<string> removeAnagrams(vector<string>& words) {
        int n = words.size();
        vector<string> result;

        int i = 0;
        while (i < n) {
            string word = words[i];
            result.push_back(word);

            vector<int> freq(26, 0);
            for (char c : word) {
                freq[c - 'a']++;
            }

            int k = i + 1;
            while (k < n) {
                bool breakDetected = false;

                if (words[k].length() != words[i].length()) {
                    break;
                }

                string next = words[k];
                vector<int> nextFreq(26, 0);
                for (char c : next) {
                    nextFreq[c - 'a']++;
                }

                for (int l = 0; l < 26; l++) {
                    if (freq[l] != nextFreq[l]) {
                        breakDetected = true;
                        break;
                    }
                }

                if (breakDetected) {
                    break;
                }

                k++;
            }

            i = k;
        }

        return result;
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
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
    vector<string> removeAnagrams(vector<string>& words) {
        vector<string> result;
        string prev = "";
        
        for (string word : words) {
            string sorted = word;
            sort(sorted.begin(), sorted.end());
            
            if (sorted != prev) {
                result.push_back(word);
                prev = sorted;
            }
        }
        
        return result;
    }
};
```
