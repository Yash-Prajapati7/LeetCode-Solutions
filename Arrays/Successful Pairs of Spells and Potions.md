Leetcode Question : [Successful Pairs of Spells and Potions](https://leetcode.com/problems/successful-pairs-of-spells-and-potions)

### Java

```java
class Solution {
    private int lowerBound(int[] potions, int spell, long target) {
        int left = 0, right = potions.length - 1;
        int mid = 0;
        int prev = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(((long) potions[mid] * spell) >= target) {
                prev = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return prev;
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];

        for(int i = 0; i < n; i++) {
            int lb = lowerBound(potions, spells[i], success);
            pairs[i] = (lb == -1) ? 0 : (m - lb);
        }

        return pairs;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int lowerBound(vector<int>& potions, int spell, long long target) {
        int left = 0, right = potions.size() - 1;
        int mid = 0;
        int prev = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if((1LL * potions[mid] * spell) >= target) {
                prev = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return prev;
    }

public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        sort(potions.begin(), potions.end());
        int n = spells.size(), m = potions.size();
        vector<int> pairs(n);

        for(int i = 0; i < n; i++) {
            int lb = lowerBound(potions, spells[i], success);
            pairs[i] = (lb == -1) ? 0 : (m - lb);
        }

        return pairs;
    }
};
```
