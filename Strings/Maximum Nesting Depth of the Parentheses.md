Leetcode Question : [Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/)

### Java

```java
class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
                depth = depth < counter ? counter : depth;
            } else if (s.charAt(i) == ')') {
                counter--;
            }
        }

        return depth;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int maxDepth(string s) {
        int counter = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                counter++;
                depth = depth < counter ? counter : depth;
            } else if (s[i] == ')') {
                counter--;
            }
        }

        return depth;
    }
};
```
