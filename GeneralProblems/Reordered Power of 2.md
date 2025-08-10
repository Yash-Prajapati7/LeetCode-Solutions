Leetcode Question : [Reordered Power of 2](https://leetcode.com/problems/reordered-power-of-2/)

### Java

```java
class Solution {
    HashSet<String> sortedDigitSet = new HashSet<>(Arrays.asList(
            "1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468", "23678",
            "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888", "11266777", "23334455",
            "01466788", "112234778", "234455668", "012356789", "0112344778"
        )
    );

    public boolean reorderedPowerOf2(int n) {
        int[] digits = new int[10];
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (digits[i] != 0) {
                for (int j = 0; j < digits[i]; j++) {
                    sb.append(i);
                }
            }
        }

        return sortedDigitSet.contains(sb.toString());
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    unordered_set<string> sortedDigitSet = {
        "1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468", "23678",
        "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888", "11266777", "23334455",
        "01466788", "112234778", "234455668", "012356789", "0112344778"
    };
public:
    bool reorderedPowerOf2(int n) {
        int digits[10] = {0};
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }

        string sb;
        for (int i = 0; i < 10; i++) {
            if (digits[i] != 0) {
                for (int j = 0; j < digits[i]; j++) {
                    sb += to_string(i);
                }
            }
        }

        return sortedDigitSet.count(sb) > 0;
    }
};
```
