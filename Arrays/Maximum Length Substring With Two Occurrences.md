Leetcode Question : [Maximum Length Substring With Two Occurrences](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/)

## Approach - 1 : Brute Force

### Java

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;

        for (int start = 0; start < s.length(); start++) {
            int[] freq = new int[26];

            for (int end = start; end < s.length(); end++) {
                int idx = s.charAt(end) - 'a';
                freq[idx]++;

                if (freq[idx] > 2) {
                    break;
                }

                ans = Math.max(ans, end - start + 1);
            }
        }

        return ans;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int maximumLengthSubstring(string s) {
        int ans = 0;

        for (int start = 0; start < s.length(); start++) {
            int freq[26] = {0};

            for (int end = start; end < s.length(); end++) {
                int idx = s[end] - 'a';
                freq[idx]++;

                if (freq[idx] > 2) {
                    break;
                }

                ans = max(ans, end - start + 1);
            }
        }

        return ans;
    }
};
```

## Approach - 2 : Sliding Window

### Java

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int endIdx = 0;
        int start = -1, startIdx = -1;
        int ans = 0;

        for (int end = 0; end < s.length(); end++) {
            endIdx = s.charAt(end) - 'a';
            freq[endIdx]++;

            while (freq[endIdx] > 2) {
                start++;
                startIdx = s.charAt(start) - 'a';
                freq[startIdx]--;
            }

            ans = (end - start) > ans ? (end - start) : ans;
        }

        return ans;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int maximumLengthSubstring(string s) {
        int freq[26] = {0};
        int endIdx = 0;
        int start = -1, startIdx = -1;
        int ans = 0;

        for (int end = 0; end < s.length(); end++) {
            endIdx = s[end] - 'a';
            freq[endIdx]++;

            while (freq[endIdx] > 2) {
                start++;
                startIdx = s[start] - 'a';
                freq[startIdx]--;
            }

            ans = (end - start) > ans ? (end - start) : ans;
        }

        return ans;
    }
};
```
