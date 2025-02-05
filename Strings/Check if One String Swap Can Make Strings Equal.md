Leetcode Question : [Check if One String Swap Can Make Strings Equal](https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/)

## Method - 1
### Java
```java
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int changes = 0;
        int[] changesInS1 = new int[26];
        int[] changesInS2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(c1 != c2) {
                changes++;
                if(changes > 2) return false;
                changesInS1[c1 - 'a']++;
                changesInS2[c2 - 'a']++;
            }
        }

        if(changes == 0) return true;
        else if(changes == 2) {
            for(int i = 0; i < 26; i++) {
                if(changesInS1[i] != changesInS2[i]) return false;
            }
            return true;
        } 

        return false;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int changes = 0;
        int changesInS1[26] = {0}, changesInS2[26] = {0};
        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1[i], c2 = s2[i];
            if(c1 != c2) {
                changes++;
                if(changes > 2) return false;
                changesInS1[c1 - 'a']++;
                changesInS2[c2 - 'a']++;
            }
        }

        if(changes == 0) return true;
        else if(changes == 2) {
            for(int i = 0; i < 26; i++) {
                if(changesInS1[i] != changesInS2[i]) return false;
            }
            return true;
        } 

        return false;
    }
};
```

## Method - 2
### Java
```java
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int changes = 0;
        int i = 0, j = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                changes++;
                if (changes > 2)
                    return false;
                else if (changes == 1) {
                    i = k;
                } else {
                    j = k;
                }
            }
        }

        return ((s1.charAt(i) == s2.charAt(j)) && (s1.charAt(j) == s2.charAt(i)));
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int changes = 0, i = 0, j = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1[k] != s2[k]) {
                changes++;
                if (changes > 2)
                    return false;
                else if (changes == 1) {
                    i = k;
                } else {
                    j = k;
                }
            }
        }

        return ((s1[i] == s2[j]) && (s1[j] == s2[i]));
    }
};
```
