Leetcode Question : [Maximum Score From Removing Substrings](https://leetcode.com/problems/maximum-score-from-removing-substrings)

## Method - 1 (Using Stack)

### Java

```java
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return getScore(s, "ab", x, y);
        } else {
            return getScore(s, "ba", y, x);
        }
    }

    private int getScore(String s, String first, int firstVal, int secondVal) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        // First remove all instances of the higher-value pair
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && c == first.charAt(1)) {
                stack.pop();
                score += firstVal;
            } else {
                stack.push(c);
            }
        }

        // Build the remaining string after first pass
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }

        // Reverse because we popped from stack
        remaining.reverse();
        stack.clear();

        // Remove all instances of the second pair
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(1) && c == first.charAt(0)) {
                stack.pop();
                score += secondVal;
            } else {
                stack.push(c);
            }
        }

        return score;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumGain(string s, int x, int y) {
        if (x > y)
            return getScore(s, "ab", x, y);
        else
            return getScore(s, "ba", y, x);
    }

private:
    int getScore(string s, string first, int firstVal, int secondVal) {
        stack<char> st;
        int score = 0;

        for (char c : s) {
            if (!st.empty() && st.top() == first[0] && c == first[1]) {
                st.pop();
                score += firstVal;
            } else {
                st.push(c);
            }
        }

        string remaining;
        while (!st.empty()) {
            remaining += st.top();
            st.pop();
        }
        reverse(remaining.begin(), remaining.end());

        for (char c : remaining) {
            if (!st.empty() && st.top() == first[1] && c == first[0]) {
                st.pop();
                score += secondVal;
            } else {
                st.push(c);
            }
        }

        return score;
    }
};
```

---

## Method - 2 (Using Counting)

### Java

```java
class Solution {
    public int maximumGain(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;

            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // remove substring "ab"
                    aCount--;
                    totalPoints += x;
                } else {
                    // if we can't form "ab" than keep b for future
                    bCount++;
                }
            } else {    
                // non 'a' 'b' character encountered
                // calculate the total for "ba" pairs
                totalPoints += Math.min(bCount, aCount) * y;
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumGain(string s, int x, int y) {
        if (x < y) {
            swap(x, y);
            reverse(s.begin(), s.end());
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (char c : s) {
            if (c == 'a') {
                aCount++;
            } else if (c == 'b') {
                if (aCount > 0) {
                    aCount--;
                    totalPoints += x;
                } else {
                    bCount++;
                }
            } else {
                totalPoints += min(aCount, bCount) * y;
                aCount = bCount = 0;
            }
        }

        totalPoints += min(aCount, bCount) * y;

        return totalPoints;
    }
};
```
