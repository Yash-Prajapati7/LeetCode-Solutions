Leetcode Question : [Find Common Characters](https://leetcode.com/problems/find-common-characters/)

### Java

```java
class Solution {
    public List<String> commonChars(String[] words) {
        // Count characters in the first word
        int[] last = count(words[0]);
        
        // Update the count array by intersecting with each subsequent word
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        
        // Build the result list based on the final count array
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    // Calculate the intersection of two count arrays
    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    // Count the frequency of each character in a word
    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[c - 'a']++;
        }
        return t;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<int> last = count(words[0]);
        
        for (int i = 1; i < words.size(); i++) {
            last = intersection(last, count(words[i]));
        }

        vector<string> arr;
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a' + i;
                string s(1, a);
                while (last[i] > 0) {
                    arr.push_back(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

private:
    vector<int> intersection(const vector<int>& a, const vector<int>& b) {
        vector<int> t(26);
        for (int i = 0; i < 26; i++) {
            t[i] = min(a[i], b[i]);
        }
        return t;
    }

    vector<int> count(const string& str) {
        vector<int> t(26, 0);
        for (char c : str) {
            t[c - 'a']++;
        }
        return t;
    }
};
```
