Leetcode Question : [Minimum Number of Swaps to Make the String Balanced](https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/)

### Java
```java
class Solution {
    public int minSwaps(String s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') 
                size++;
            else if (size > 0) 
                size--;
        }
        return (size + 1) / 2;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minSwaps(string s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '[') 
                size++;
            else if (size > 0) 
                size--;
        }
        return (size + 1) / 2;
    }
};
```
