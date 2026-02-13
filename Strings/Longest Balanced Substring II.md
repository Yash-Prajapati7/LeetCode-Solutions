Leetcode Question : [Longest Balanced Substring II](https://leetcode.com/problems/longest-balanced-substring-ii/)

### Java

```java
class Solution {
    public int longestBalanced(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if(length == 1) return 1;

        int currentAStreak = 0, currentBStreak = 0, currentCStreak = 0;
        int maxAStreak = 0, maxBStreak = 0, maxCStreak = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] == 'a') {
                currentAStreak = (i > 0 && chars[i - 1] == 'a') ? currentAStreak + 1 : 1;
                maxAStreak = Math.max(maxAStreak, currentAStreak);
            } 
            else if (chars[i] == 'b') {
                currentBStreak = (i > 0 && chars[i - 1] == 'b') ? currentBStreak + 1 : 1;
                maxBStreak = Math.max(maxBStreak, currentBStreak);
            } 
            else {
                currentCStreak = (i > 0 && chars[i - 1] == 'c') ? currentCStreak + 1 : 1;
                maxCStreak = Math.max(maxCStreak, currentCStreak);
            }
        }

        int maxBalancedLength = Math.max(Math.max(maxAStreak, maxBStreak), maxCStreak);

        maxBalancedLength = Math.max(maxBalancedLength, findTwoLetterBalanced(chars, 'a', 'b'));
        maxBalancedLength = Math.max(maxBalancedLength, findTwoLetterBalanced(chars, 'a', 'c'));
        maxBalancedLength = Math.max(maxBalancedLength, findTwoLetterBalanced(chars, 'b', 'c'));

        maxBalancedLength = Math.max(maxBalancedLength, findThreeLetterBalanced(chars));

        return maxBalancedLength;
    }

    private int findTwoLetterBalanced(char[] chars, char letter1, char letter2) {
        int n = chars.length;
        int maxLength = 0;

        int[] firstSeenAtIndex = new int[(n << 1) + 1];
        Arrays.fill(firstSeenAtIndex, -2);

        int segmentStartBoundary = -1;
        int countDifference = n;

        firstSeenAtIndex[countDifference] = -1;

        for (int i = 0; i < n; i++) {
            if (chars[i] != letter1 && chars[i] != letter2) {
                segmentStartBoundary = i;
                countDifference = n;
                firstSeenAtIndex[countDifference] = segmentStartBoundary;
            } 
            else {
                if (chars[i] == letter1) {
                    countDifference++;
                } else {
                    countDifference--;
                }

                if (firstSeenAtIndex[countDifference] < segmentStartBoundary) {
                    firstSeenAtIndex[countDifference] = i;
                } else {
                    maxLength = Math.max(maxLength, i - firstSeenAtIndex[countDifference]);
                }
            }
        }

        return maxLength;
    }

    private int findThreeLetterBalanced(char[] chars) {

        long encodedState = Long.MAX_VALUE >> 1;
        Map<Long, Integer> firstOccurrenceIndex = new HashMap<>();
        firstOccurrenceIndex.put(encodedState, -1);

        int maxLength = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'a') {
                encodedState += 1_000_001;
            } 
            else if (chars[i] == 'b') {
                encodedState -= 1_000_000;
            } 
            else {
                encodedState -= 1;
            }

            if (firstOccurrenceIndex.containsKey(encodedState)) {
                maxLength = Math.max(maxLength, i - firstOccurrenceIndex.get(encodedState));
            } else {
                firstOccurrenceIndex.put(encodedState, i);
            }
        }

        return maxLength;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        vector<char> chars(s.begin(), s.end());
        int length = chars.size();
        if(length == 1) return 1;

        int currentAStreak = 0, currentBStreak = 0, currentCStreak = 0;
        int maxAStreak = 0, maxBStreak = 0, maxCStreak = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] == 'a') {
                currentAStreak = (i > 0 && chars[i - 1] == 'a') ? currentAStreak + 1 : 1;
                maxAStreak = max(maxAStreak, currentAStreak);
            } 
            else if (chars[i] == 'b') {
                currentBStreak = (i > 0 && chars[i - 1] == 'b') ? currentBStreak + 1 : 1;
                maxBStreak = max(maxBStreak, currentBStreak);
            } 
            else {
                currentCStreak = (i > 0 && chars[i - 1] == 'c') ? currentCStreak + 1 : 1;
                maxCStreak = max(maxCStreak, currentCStreak);
            }
        }

        int maxBalancedLength = max(max(maxAStreak, maxBStreak), maxCStreak);

        maxBalancedLength = max(maxBalancedLength, findTwoLetterBalanced(chars, 'a', 'b'));
        maxBalancedLength = max(maxBalancedLength, findTwoLetterBalanced(chars, 'a', 'c'));
        maxBalancedLength = max(maxBalancedLength, findTwoLetterBalanced(chars, 'b', 'c'));

        maxBalancedLength = max(maxBalancedLength, findThreeLetterBalanced(chars));

        return maxBalancedLength;
    }

private:
    int findTwoLetterBalanced(vector<char>& chars, char letter1, char letter2) {
        int n = chars.size();
        int maxLength = 0;

        vector<int> firstSeenAtIndex((n << 1) + 1, -2);

        int segmentStartBoundary = -1;
        int countDifference = n;

        firstSeenAtIndex[countDifference] = -1;

        for (int i = 0; i < n; i++) {
            if (chars[i] != letter1 && chars[i] != letter2) {
                segmentStartBoundary = i;
                countDifference = n;
                firstSeenAtIndex[countDifference] = segmentStartBoundary;
            } 
            else {
                if (chars[i] == letter1) {
                    countDifference++;
                } else {
                    countDifference--;
                }

                if (firstSeenAtIndex[countDifference] < segmentStartBoundary) {
                    firstSeenAtIndex[countDifference] = i;
                } else {
                    maxLength = max(maxLength, i - firstSeenAtIndex[countDifference]);
                }
            }
        }

        return maxLength;
    }

    int findThreeLetterBalanced(vector<char>& chars) {
        long long encodedState = LLONG_MAX >> 1;
        unordered_map<long long, int> firstOccurrenceIndex;
        firstOccurrenceIndex[encodedState] = -1;

        int maxLength = 0;

        for (int i = 0; i < chars.size(); i++) {

            if (chars[i] == 'a') {
                encodedState += 1000001LL;
            } 
            else if (chars[i] == 'b') {
                encodedState -= 1000000LL;
            } 
            else {
                encodedState -= 1LL;
            }

            if (firstOccurrenceIndex.count(encodedState)) {
                maxLength = max(maxLength, i - firstOccurrenceIndex[encodedState]);
            } else {
                firstOccurrenceIndex[encodedState] = i;
            }
        }

        return maxLength;
    }
};
```
