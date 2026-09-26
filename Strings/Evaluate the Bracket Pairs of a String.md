### Leetcode Question : [Evaluate the Bracket Pairs of a String](https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/)

### Java

```java
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int endPointer = 0;
        int n = s.length();
        int i = 0;

        StringBuilder key = new StringBuilder(10); // At max the key size is 10
        StringBuilder result = new StringBuilder(n);
        String k = "";

        HashMap<String, String> keyVals = new HashMap<>(knowledge.size());
        boolean keyDetected = false;

        for (List<String> innerList : knowledge) {
            keyVals.put(innerList.get(0), innerList.get(1));
        }

        while (i < n) {
            if (s.charAt(i) == '(') {
                keyDetected = true;
                endPointer = i + 1;
                key = new StringBuilder(10);

                while (endPointer < n && s.charAt(endPointer) != ')') {
                    key.append(s.charAt(endPointer));
                    endPointer++;
                }
            }

            if (keyDetected) {
                k = key.toString();
                if (keyVals.containsKey(k)) {
                    result.append(keyVals.get(k));
                } else {
                    result.append("?");
                }

                i = endPointer + 1;
                keyDetected = false;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return new String(result);
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        int endPointer = 0;
        int n = s.length();
        int i = 0;

        string key; // At max the key size is 10
        string result;
        result.reserve(n);
        string k = "";

        unordered_map<string, string> keyVals;
        bool keyDetected = false;

        for (vector<string>& innerList : knowledge) {
            keyVals[innerList[0]] = innerList[1];
        }

        while (i < n) {
            if (s[i] == '(') {
                keyDetected = true;
                endPointer = i + 1;
                key = "";

                while (endPointer < n && s[endPointer] != ')') {
                    key += s[endPointer];
                    endPointer++;
                }
            }

            if (keyDetected) {
                k = key;
                if (keyVals.count(k)) {
                    result += keyVals[k];
                } else {
                    result += "?";
                }

                i = endPointer + 1;
                keyDetected = false;
            } else {
                result += s[i];
                i++;
            }
        }

        return result;
    }
};
```
