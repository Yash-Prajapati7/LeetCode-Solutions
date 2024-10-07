Leetcode Question: [Multiply Strings](https://leetcode.com/problems/multiply-strings/)

### Java
```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0') {
            return "0";
        }
        if (num2.length() == 1 && num2.charAt(0) == '0') {
            return "0";
        }

        int l1 = num1.length(), l2 = num2.length();
        int[] arr = new int[l1 + l2];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = p1 + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + arr[p2];
                arr[p1] += sum / 10;
                arr[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            if (!(sb.length() == 0 && n == 0)) {
                sb.append(n);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1.length() == 1 && num1[0] == '0') {
            return "0";
        }
        if (num2.length() == 1 && num2[0] == '0') {
            return "0";
        }

        int l1 = num1.length(), l2 = num2.length();
        vector<int> arr(l1 + l2, 0);
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = p1 + 1;
                int mul = (num1[i] - '0') * (num2[j] - '0');
                int sum = mul + arr[p2];
                arr[p1] += sum / 10;
                arr[p2] = sum % 10;
            }
        }
        string result;
        for (int n : arr) {
            if (!(result.length() == 0 && n == 0)) {
                result.push_back(n + '0');
            }
        }

        return result.empty() ? "0" : result;
    }
};
```
