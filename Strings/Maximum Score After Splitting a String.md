Leetcode Question : [Maximum Score After Splitting a String](https://leetcode.com/problems/maximum-score-after-splitting-a-string/)

### Java
```java
class Solution {
    public int maxScore(String s) {
        int ones = 0, zeros = 0, max = 0;
        char[] str = s.toCharArray();

        for(char c : str) {
            ones += (c - '0');
        }

        if(ones == 0) return 1;

        for(int i = 0; i < str.length - 1; i++) {
            if(str[i] - '0' == 0) {
                zeros++;
            }
            else {
                ones--;
            }
            
            max = max < (zeros + ones) ? zeros + ones : max;
        }

        return max;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxScore(string s) {
        int ones = 0, zeros = 0, max = 0;
        vector<char> str(s.begin(), s.end());

        for(char c : str) {
            ones += (c - '0');
        }

        if(ones == 0) return 1;

        for(int i = 0; i < str.size() - 1; i++) {
            if(str[i] - '0' == 0) {
                zeros++;
            }
            else {
                ones--;
            }
            
            max = max < (zeros + ones) ? zeros + ones : max;
        }

        return max;
    }
};
```
