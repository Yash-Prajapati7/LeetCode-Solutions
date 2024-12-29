Leetcode Question: [Faulty Keyboard](https://leetcode.com/problems/faulty-keyboard/)

### Java
```java
class Solution {
    public String finalString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string finalString(string s) {
        string result;
        
        for (char ch : s) {
            if (ch == 'i') {
                reverse(result.begin(), result.end());
            } else {
                result.push_back(ch);
            }
        }
        
        return result;
    }
};
```
