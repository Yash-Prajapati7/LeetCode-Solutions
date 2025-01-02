Leetcode Question: [Count Vowel Strings in Ranges](https://leetcode.com/problems/count-vowel-strings-in-ranges/)

## Method - 1
### Java
```java
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] numberOfStrings = new int[n];
        int[] ans = new int[queries.length];
        String vowels = "aeiou";

        // Initialize the first value in the cumulative array
        int len = words[0].length();
        numberOfStrings[0] = (vowels.indexOf(words[0].charAt(0)) != -1 && vowels.indexOf(words[0].charAt(len - 1)) != -1) ? 1 : 0;

        // Build the cumulative array
        for (int i = 1; i < n; i++) {
            len = words[i].length();
            numberOfStrings[i] = numberOfStrings[i - 1] +
                    (vowels.indexOf(words[i].charAt(0)) != -1 && vowels.indexOf(words[i].charAt(len - 1)) != -1 ? 1 : 0);
        }

        // Process the queries
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l == 0 ? numberOfStrings[r] : numberOfStrings[r] - numberOfStrings[l - 1];
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
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int n = words.size();
        vector<int> numberOfStrings(n, 0);
        vector<int> ans(queries.size());
        string vowels = "aeiou";

        // Initialize the first value in the cumulative array
        int len = words[0].length();
        numberOfStrings[0] = (vowels.find(words[0][0]) != string::npos && vowels.find(words[0][len - 1]) != string::npos) ? 1 : 0;

        // Build the cumulative array
        for (int i = 1; i < n; i++) {
            len = words[i].length();
            numberOfStrings[i] = numberOfStrings[i - 1] +
                                 (vowels.find(words[i][0]) != string::npos && vowels.find(words[i][len - 1]) != string::npos ? 1 : 0);
        }

        // Process the queries
        for (int i = 0; i < queries.size(); i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l == 0 ? numberOfStrings[r] : numberOfStrings[r] - numberOfStrings[l - 1];
        }

        return ans;
    }
};
```

## Method - 2
### Java
```java
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] numberOfStrings = new int[n];
        int[] ans = new int[queries.length];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int len = words[0].length();
        numberOfStrings[0] = (vowels.contains(words[0].charAt(0)) && vowels.contains(words[0].charAt(len - 1))) ? 1 : 0;

        // Build the cumulative array
        for (int i = 1; i < n; i++) {
            len = words[i].length();

            // Check if the word starts and ends with a vowel
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(len - 1))) {
                numberOfStrings[i] = numberOfStrings[i - 1] + 1;
            } else {
                numberOfStrings[i] = numberOfStrings[i - 1];
            }
        }

        // Process the queries
        int k = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            ans[k++] = l == 0 ? numberOfStrings[r] : numberOfStrings[r] - numberOfStrings[l - 1];
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
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int n = words.size();
        vector<int> numberOfStrings(n, 0);
        vector<int> ans(queries.size());
        unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u'};

        int len = words[0].length();
        numberOfStrings[0] = (vowels.count(words[0][0]) && vowels.count(words[0][len - 1])) ? 1 : 0;

        // Build the cumulative array
        for (int i = 1; i < n; i++) {
            len = words[i].length();

            // Check if the word starts and ends with a vowel
            if (vowels.count(words[i][0]) && vowels.count(words[i][len - 1])) {
                numberOfStrings[i] = numberOfStrings[i - 1] + 1;
            } else {
                numberOfStrings[i] = numberOfStrings[i - 1];
            }
        }

        // Process the queries
        for (int i = 0; i < queries.size(); i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l == 0 ? numberOfStrings[r] : numberOfStrings[r] - numberOfStrings[l - 1];
        }

        return ans;
    }
};
```
