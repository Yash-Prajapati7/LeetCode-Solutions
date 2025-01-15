Leetcode Question: [Shifting Letters](https://leetcode.com/problems/shifting-letters/)

### Java
```java
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long total = 0;
        for(int shift : shifts) total += shift;

        if(total == 0) return s;
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++) {
            c[i] = (char)(((c[i] - 'a' + total) % 26) + 'a');
            total -= shifts[i];
        }

        return new String(c);
    }
}
```

### C++
```cpp
class Solution {
public:
    string shiftingLetters(string s, vector<int>& shifts) {
        long long total = 0;
        for (int shift : shifts) total += shift;

        if (total == 0) return s;
        vector<char> c(s.begin(), s.end());

        for (size_t i = 0; i < c.size(); i++) {
            c[i] = (char)(((c[i] - 'a' + total) % 26) + 'a');
            total -= shifts[i];
        }

        return string(c.begin(), c.end());
    }
};
```
