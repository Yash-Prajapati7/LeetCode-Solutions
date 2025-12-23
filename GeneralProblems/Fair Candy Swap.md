Leetcode Question : [Fair Candy Swap](https://leetcode.com/problems/fair-candy-swap/)

### Java

```java
class Solution {
    public int[] fairCandySwap(int[] aliceCandies, int[] bobCandies) {
        int candyDifference = (IntStream.of(aliceCandies).sum() - IntStream.of(bobCandies).sum()) / 2;

        HashSet<Integer> aliceCandySet = new HashSet<>();
        for (int aliceCandy : aliceCandies) {
            aliceCandySet.add(aliceCandy);
        }

        for (int bobCandy : bobCandies) {
            if (aliceCandySet.contains(bobCandy + candyDifference)) {
                return new int[] { bobCandy + candyDifference, bobCandy };
            }
        }

        return new int[0];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> fairCandySwap(vector<int>& aliceCandies, vector<int>& bobCandies) {
        int sumAlice = 0, sumBob = 0;

        for (int candy : aliceCandies) sumAlice += candy;
        for (int candy : bobCandies) sumBob += candy;

        int candyDifference = (sumAlice - sumBob) / 2;

        unordered_set<int> aliceCandySet;
        for (int aliceCandy : aliceCandies) {
            aliceCandySet.insert(aliceCandy);
        }

        for (int bobCandy : bobCandies) {
            if (aliceCandySet.count(bobCandy + candyDifference)) {
                return {bobCandy + candyDifference, bobCandy};
            }
        }

        return {};
    }
};
```
