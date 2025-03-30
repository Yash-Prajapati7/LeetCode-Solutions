Leetcode Question : [Partition Labels](https://leetcode.com/problems/partition-labels)  

### Java  
```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(1);
            return ans;
        }

        int[] lastseen = new int[26];
        for(int i = 0; i < n; i++) {
            lastseen[chars[i] - 'a'] = i;
        }

        int start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            end = end < lastseen[chars[i] - 'a'] ? lastseen[chars[i] - 'a'] : end;
            if(i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
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
    vector<int> partitionLabels(string s) {
        int n = s.size();
        vector<int> ans;
        if (n == 1) {
            ans.push_back(1);
            return ans;
        }

        vector<int> lastseen(26, 0);
        for (int i = 0; i < n; i++) {
            lastseen[s[i] - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = max(end, lastseen[s[i] - 'a']);
            if (i == end) {
                ans.push_back(end - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
};
```
