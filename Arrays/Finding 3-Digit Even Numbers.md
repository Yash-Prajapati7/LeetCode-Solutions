Leetcode Question : [Finding 3-Digit Even Numbers](https://leetcode.com/problems/finding-3-digit-even-numbers/)

### Java

```java
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int a, b, c;
        for(int i = 100; i <= 998; i += 2) {
            int[] seen = new int[10];
            for(int digit : digits) seen[digit]++;

            a = i / 100;
            b = (i / 10) % 10;
            c = i % 10;

            if(seen[a] > 0) {
                seen[a]--;
                if(seen[b] > 0) {
                    seen[b]--;
                    if(seen[c] > 0) {
                        result.add(i);
                    }
                    seen[b]++;
                }
                seen[a]++;
            }
        }

        int n = result.size();
        int[] ans = new int[n];
        if(n == 0) return ans;

        for(int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        Arrays.sort(ans);
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
    vector<int> findEvenNumbers(vector<int>& digits) {
        vector<int> result;
        int a, b, c;
        for(int i = 100; i <= 998; i += 2) {
            vector<int> seen(10, 0);
            for(int digit : digits) seen[digit]++;

            a = i / 100;
            b = (i / 10) % 10;
            c = i % 10;

            if(seen[a] > 0) {
                seen[a]--;
                if(seen[b] > 0) {
                    seen[b]--;
                    if(seen[c] > 0) {
                        result.push_back(i);
                    }
                    seen[b]++;
                }
                seen[a]++;
            }
        }

        sort(result.begin(), result.end());
        return result;
    }
};
```
