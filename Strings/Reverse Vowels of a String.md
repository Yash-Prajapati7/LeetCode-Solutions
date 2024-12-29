Leetcode Question: [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)

### Java

```java
class Solution {
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        char temp;

        while(left < right) {
            while(left < right && !isVowel(c[left])) left++;
            while(left < right && !isVowel(c[right])) right--;

            temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }

        return new String(c);
    }
}
```

### C++

```cpp
class Solution {
private:
    bool isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
public:
    string reverseVowels(string s) {
        int left = 0, right = s.length() - 1;
        char temp;

        while (left < right) {
            while (left < right && !isVowel(s[left])) left++;
            while (left < right && !isVowel(s[right])) right--;

            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        return s;
    }
};
```
