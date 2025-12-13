Leetcode Question : [Coupon Code Validator](https://leetcode.com/problems/coupon-code-validator/)

### Java

```java
class Solution {
    private boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }

        char c = 'a';
        boolean isAlpha = false, isDigit = false, isUnderScore = false;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            isAlpha = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            isDigit = (c >= '0' && c <= '9');
            isUnderScore = (c == '_');

            if (!(isAlpha || isDigit || isUnderScore)) {
                return false;
            }
        }

        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        ArrayList<String>[] coupons = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            coupons[i] = new ArrayList<>();
        }

        for (int i = 0; i < code.length; i++) {
            if (isValid(code[i]) && isActive[i]) {
                switch (businessLine[i]) {
                    case "electronics":
                        coupons[0].add(code[i]);
                        break;
                    case "grocery":
                        coupons[1].add(code[i]);
                        break;
                    case "pharmacy":
                        coupons[2].add(code[i]);
                        break;
                    case "restaurant":
                        coupons[3].add(code[i]);
                        break;
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Collections.sort(coupons[i]);
            for (int j = 0; j < coupons[i].size(); j++) {
                result.add(coupons[i].get(j));
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    bool isValid(string s) {
        if (s.length() == 0) {
            return false;
        }

        char c = 'a';
        bool isAlpha = false, isDigit = false, isUnderScore = false;
        for (int i = 0; i < s.length(); i++) {
            c = s[i];
            isAlpha = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            isDigit = (c >= '0' && c <= '9');
            isUnderScore = (c == '_');

            if (!(isAlpha || isDigit || isUnderScore)) {
                return false;
            }
        }

        return true;
    }

public:
    vector<string> validateCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        vector<vector<string>> coupons(4);

        for (int i = 0; i < code.size(); i++) {
            if (isValid(code[i]) && isActive[i]) {
                if (businessLine[i] == "electronics") {
                    coupons[0].push_back(code[i]);
                } else if (businessLine[i] == "grocery") {
                    coupons[1].push_back(code[i]);
                } else if (businessLine[i] == "pharmacy") {
                    coupons[2].push_back(code[i]);
                } else if (businessLine[i] == "restaurant") {
                    coupons[3].push_back(code[i]);
                }
            }
        }

        vector<string> result;
        for (int i = 0; i < 4; i++) {
            sort(coupons[i].begin(), coupons[i].end());
            for (int j = 0; j < coupons[i].size(); j++) {
                result.push_back(coupons[i][j]);
            }
        }

        return result;
    }
};
```
