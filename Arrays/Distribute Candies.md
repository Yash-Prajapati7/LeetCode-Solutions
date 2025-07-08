Leetcode Question : [Distribute Candies](https://leetcode.com/problems/distribute-candies/)

### Java

```java
class Solution {
    public int distributeCandies(int[] candyType) {
        int max = candyType.length;
        HashSet<Integer> uniqueCandies = new HashSet<>(max);

        for(int candy : candyType) {
            uniqueCandies.add(candy);
        }

        max >>= 1;
        int candies = uniqueCandies.size();

        return max < candies ? max : candies;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        int max = candyType.size();
        unordered_set<int> uniqueCandies;

        for(int candy : candyType) {
            uniqueCandies.insert(candy);
        }

        max >>= 1;
        int candies = uniqueCandies.size();

        return max < candies ? max : candies;
    }
};
```
