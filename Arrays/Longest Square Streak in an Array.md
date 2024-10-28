Leetcode Question : [Longest Square Streak in an Array](https://leetcode.com/problems/longest-square-streak-in-an-array/)

### Java
```java
class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxVal = (int) Math.sqrt(1e5) + 1;
        int maxStreak = 0;
        Set<Integer> elements = new HashSet<>();

        for (int num : nums) {
            elements.add(num);
        }

        for (int i = 1; i <= maxVal; i++) {
            int num = i;
            int currentStreak = 0;

            while (elements.contains(num)) {
                currentStreak++;
                num *= num;
                if (num > 1e5) break;
            }
            maxStreak = Math.max(maxStreak, currentStreak);
        }
        return maxStreak >= 2 ? maxStreak : -1;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        int maxVal = sqrt(1e5) + 1;
        int maxStreak = 0;
        unordered_set<int> elements(nums.begin(), nums.end());

        for (int i = 1; i <= maxVal; i++) {
            int num = i;
            int currentStreak = 0;

            while (elements.count(num)) {
                currentStreak++;
                num *= num;
                if (num > 1e5) break;
            }
            maxStreak = max(maxStreak, currentStreak);
        }
        return maxStreak >= 2 ? maxStreak : -1;
    }
};
```
