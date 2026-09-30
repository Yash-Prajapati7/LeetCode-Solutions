Leetcode Question : [Maximum Nesting Depth of Two Valid Parentheses Strings](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/)

### Java

```java id="4k9xwm"
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int n = seq.length();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                result[i] = depth % 2;
                depth++;
            } else {
                depth--;
                result[i] = depth % 2;
            }
        }

        return result;
    }
}
```

### C++

```cpp id="7v2qnf"
using namespace std;

class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        int depth = 0;
        int n = seq.length();
        vector<int> result(n);

        for (int i = 0; i < n; i++) {
            if (seq[i] == '(') {
                result[i] = depth % 2;
                depth++;
            } else {
                depth--;
                result[i] = depth % 2;
            }
        }

        return result;
    }
};
```
