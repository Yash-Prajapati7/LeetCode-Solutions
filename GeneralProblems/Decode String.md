Leetcode Question : [Decode String](https://leetcode.com/problems/decode-string/)

## Method - 1 (Recursive)

### Java

```java
class Solution {
    int i = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (i < s.length() && s.charAt(i) != ']') {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
                i++;
            } 
            else if (ch == '[') {
                i++;
                String decoded = decodeString(s);

                for (int j = 0; j < k; j++) {
                    result.append(decoded);
                }
                k = 0;
                i++;
            } 
            else {
                result.append(ch);
                i++;
            }
        }
        return result.toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int i = 0;

    string decodeString(string s) {
        string result = "";
        int k = 0;

        while (i < s.length() && s[i] != ']') {
            char ch = s[i];

            if (isdigit(ch)) {
                k = k * 10 + (ch - '0');
                i++;
            } 
            else if (ch == '[') {
                i++;
                string decoded = decodeString(s);

                while (k--) {
                    result += decoded;
                }
                k = 0;
                i++;
            } 
            else {
                result += ch;
                i++;
            }
        }
        return result;
    }
};
```

---

## Method - 2 (Stack Based)

### Java

```java
import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);

                k = 0;
                currentString = new StringBuilder();
            } 
            else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < count; i++) {
                    prev.append(currentString);
                }

                currentString = prev;
            } 
            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<int> countStack;
        stack<string> stringStack;

        string currentString = "";
        int k = 0;

        for (char ch : s) {

            if (isdigit(ch)) {
                k = k * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);

                k = 0;
                currentString = "";
            } 
            else if (ch == ']') {
                int count = countStack.top();
                countStack.pop();

                string prev = stringStack.top();
                stringStack.pop();

                string temp = "";
                for (int i = 0; i < count; i++) {
                    temp += currentString;
                }

                currentString = prev + temp;
            } 
            else {
                currentString += ch;
            }
        }

        return currentString;
    }
};
```
