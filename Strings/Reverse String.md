Leetcode Question: [Reverse String](https://leetcode.com/problems/reverse-string/)

### Java

```java
class Solution {
    public void reverseString(char[] s) {
        char c;
        int left = 0, right = s.length - 1;

        while(left < right) {
            c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
```

### C++

```cpp
class Solution {
public:
    void reverseString(vector<char>& s) {
        char c;
        int left = 0, right = s.size() - 1;

        while (left < right) {
            c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
};
```
