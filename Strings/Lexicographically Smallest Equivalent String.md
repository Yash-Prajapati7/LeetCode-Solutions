Leetcode Question : [Lexicographically Smallest Equivalent String](https://leetcode.com/problems/lexicographically-smallest-equivalent-string/)

### Java

```java
class Solution {
    private static int find(int i, int[] parent) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
            
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int u = find((s1.charAt(i) - 'a'), parent);
            int v = find((s2.charAt(i) - 'a'), parent);
            if (u < v)
                parent[v] = u;
            else
                parent[u] = v;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int idx = baseStr.charAt(i) - 'a';
            int top = find(parent[idx], parent);
            sb.append((char) (top + 'a'));
        }

        return new String(sb);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    static int find(int i, vector<int>& parent) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        vector<int> parent(26);
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int u = find(s1[i] - 'a', parent);
            int v = find(s2[i] - 'a', parent);
            if (u < v)
                parent[v] = u;
            else
                parent[u] = v;
        }

        string res;
        for (char c : baseStr) {
            int idx = c - 'a';
            int top = find(parent[idx], parent);
            res += (char)(top + 'a');
        }

        return res;
    }
};
```
