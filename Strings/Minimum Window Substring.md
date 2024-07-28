Leetcode Question : [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
### Java
```java
import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int count = 0;
        int minlength = Integer.MAX_VALUE;
        int startIndex = -1;
        int m = t.length();
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < n) {
            char rightChar = s.charAt(right);
            if (map.getOrDefault(rightChar, 0) > 0) {
                count++;
            }
            map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);

            while (count == m) {
                if (right - left + 1 < minlength) {
                    minlength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                if (map.get(leftChar) > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minlength);
    }
}
```
### C++
```cpp
#include <unordered_map>
#include <string>
#include <climits>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        int left = 0;
        int right = 0;
        int count = 0;
        int minlength = INT_MAX;
        int startIndex = -1;
        int m = t.length();
        int n = s.length();

        unordered_map<char, int> map;
        for (int i = 0; i < m; i++) {
            map[t[i]]++;
        }

        while (right < n) {
            char rightChar = s[right];
            if (map[rightChar] > 0) {
                count++;
            }
            map[rightChar]--;

            while (count == m) {
                if (right - left + 1 < minlength) {
                    minlength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s[left];
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return (startIndex == -1) ? "" : s.substr(startIndex, minlength);
    }
};
```
