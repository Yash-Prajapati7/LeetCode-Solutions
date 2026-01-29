Leetcode Question : [Minimum Cost to Convert String I](https://leetcode.com/problems/minimum-cost-to-convert-string-i/)

### Java

```java
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] edges = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(edges[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < original.length; i++) {
            int src = original[i] - 'a';
            int dest = changed[i] - 'a';
            edges[src][dest] = Math.min(edges[src][dest], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (edges[i][k] != Long.MAX_VALUE && edges[k][j] != Long.MAX_VALUE) {
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                    }
                }
            }
        }

        long result = 0;

        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';

            if (src != dest) {
                if (edges[src][dest] == Long.MAX_VALUE) {
                    return -1;
                }
                result += edges[src][dest];
            }
        }

        return result;
    }
}
```

### C++

```cpp
class Solution {
public:
    long long minimumCost(string source, string target, vector<char>& original, vector<char>& changed, vector<int>& cost) {
        vector<vector<long long>> edges(26, vector<long long>(26, LLONG_MAX));

        for (int i = 0; i < original.size(); i++) {
            int src = original[i] - 'a';
            int dest = changed[i] - 'a';
            edges[src][dest] = min(edges[src][dest], (long long)cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (edges[i][k] != LLONG_MAX && edges[k][j] != LLONG_MAX) {
                        edges[i][j] = min(edges[i][j], edges[i][k] + edges[k][j]);
                    }
                }
            }
        }

        long long result = 0;

        for (int i = 0; i < source.length(); i++) {
            int src = source[i] - 'a';
            int dest = target[i] - 'a';

            if (src != dest) {
                if (edges[src][dest] == LLONG_MAX) {
                    return -1;
                }
                result += edges[src][dest];
            }
        }

        return result;
    }
};
```
