LeetCode Question : [Rotate String](https://leetcode.com/problems/rotate-string)

### Java

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        s = s + s;
        return s.contains(goal);
    }
}
```

### C++

```cpp
class Solution {
public:
    bool rotateString(string s, string goal) {
        if (s.size() != goal.size()) {
            return false;
        }

        s = s + s;
        return s.find(goal) != string::npos;
    }
};
```
