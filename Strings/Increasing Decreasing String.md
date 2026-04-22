Leetcode Question : [Increasing Decreasing String](https://leetcode.com/problems/increasing-decreasing-string/)

## Approach - 1 (Using TreeSet)

### Java

```java
class Solution {
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        TreeMap<Character, Integer> tm = new TreeMap<>();

        for (char c : s.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }

        boolean asc = true;
        while (!tm.isEmpty()) {
            for (char c : asc ? new TreeSet<>(tm.keySet()) : new TreeSet<>(tm.descendingKeySet())) {
                ans.append(c);
                tm.put(c, tm.get(c) - 1);
                tm.remove(c, 0);
            }
            asc = !asc;
        }

        return ans.toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string sortString(string s) {
        string ans = "";
        map<char, int> tm;

        for (char c : s) {
            tm[c]++;
        }

        bool asc = true;
        while (!tm.empty()) {
            vector<char> keys;

            if (asc) {
                for (auto &p : tm) keys.push_back(p.first);
            } else {
                for (auto it = tm.rbegin(); it != tm.rend(); ++it)
                    keys.push_back(it->first);
            }

            for (char c : keys) {
                ans.push_back(c);
                tm[c]--;
                if (tm[c] == 0) {
                    tm.erase(c);
                }
            }
            asc = !asc;
        }

        return ans;
    }
};
```

## Approach - 2 (Using Arrays)

### Java

```java
public String sortString(String s) {
    StringBuilder ans = new StringBuilder();
    int[] count = new int[26];
    for (char c : s.toCharArray())
        ++count[c - 'a'];
    while (ans.length() < s.length()) {
        add(count, ans, true);
        add(count, ans, false);
    }
    return ans.toString();
}

private void add(int[] cnt, StringBuilder ans, boolean asc) {
    for (int i = 0; i < 26; ++i) {
        int j = asc ? i : 25 - i;
        if (cnt[j]-- > 0)
            ans.append((char)(j + 'a'));
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string sortString(string s) {
        string ans = "";
        vector<int> count(26, 0);

        for (char c : s)
            count[c - 'a']++;

        while (ans.length() < s.length()) {
            add(count, ans, true);
            add(count, ans, false);
        }

        return ans;
    }

    void add(vector<int> &cnt, string &ans, bool asc) {
        for (int i = 0; i < 26; ++i) {
            int j = asc ? i : 25 - i;
            if (cnt[j]-- > 0)
                ans.push_back(char(j + 'a'));
        }
    }
};
```
