Leetcode Question: [Shifting Letters II](https://leetcode.com/problems/shifting-letters-ii/)

### Java
```java
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                prefix[shift[0]]++;
                prefix[shift[1] + 1]--;
            } else {
                prefix[shift[0]]--;
                prefix[shift[1] + 1]++;
            }
        }

        char[] result = s.toCharArray();
        int numberOfShifts = 0;

        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + prefix[i]) % 26;
            if (numberOfShifts < 0) numberOfShifts += 26;

            result[i] = (char)(((s.charAt(i) - 'a' + numberOfShifts) % 26) + 'a');
        }

        return new String(result);
    }
}
```

### C++
```cpp
class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = s.size();
        vector<int> prefix(n + 1, 0);

        for (auto& shift : shifts) {
            if (shift[2] == 1) {
                prefix[shift[0]]++;
                prefix[shift[1] + 1]--;
            } else {
                prefix[shift[0]]--;
                prefix[shift[1] + 1]++;
            }
        }

        vector<char> result(s.begin(), s.end());
        int numberOfShifts = 0;

        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + prefix[i]) % 26;
            if (numberOfShifts < 0) numberOfShifts += 26;

            result[i] = ((s[i] - 'a' + numberOfShifts) % 26) + 'a';
        }

        return string(result.begin(), result.end());
    }
};
```
