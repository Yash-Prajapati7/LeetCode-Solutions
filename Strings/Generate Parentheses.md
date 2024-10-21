Leetcode Question : [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

### Java
```java
class Solution {
    public static void generate(List<String> result, String current, int open, int close, int max) {
        if (open > max || close > max || close > open)
            return;
        if (open == max && close == max) {
            result.add(current);
            return;
        }

        generate(result, current + "(", open + 1, close, max);
        generate(result, current + ")", open, close + 1, max);

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
}
```

### C++
```cpp
class Solution {
public:
    static void generate(vector<string>& result, string current, int open, int close, int max) {
        if (open > max || close > max || close > open)
            return;
        if (open == max && close == max) {
            result.push_back(current);
            return;
        }

        generate(result, current + "(", open + 1, close, max);
        generate(result, current + ")", open, close + 1, max);
    }

    vector<string> generateParenthesis(int n) {
        vector<string> result;
        generate(result, "", 0, 0, n);
        return result;
    }
};
```
