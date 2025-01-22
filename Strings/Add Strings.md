Leetcode Question : [Add Strings](https://leetcode.com/problems/add-strings/)

### Java
```java
class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        StringBuilder ans = new StringBuilder(n1 + n2 + 1);
        int i = n1 - 1, j = n2 - 1, carry = 0, sum = 0, digit1 = 0, digit2 = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            digit1 = i >= 0 ? num1.charAt(i) - '0' : 0; 
            digit2 = j >= 0 ? num2.charAt(j) - '0' : 0; 
            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            ans.append(sum % 10); 
            i--; 
            j--;
        }

        return ans.reverse().toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string addStrings(string num1, string num2) {
        int n1 = num1.length(), n2 = num2.length();
        string ans;
        int i = n1 - 1, j = n2 - 1, carry = 0, sum = 0, digit1 = 0, digit2 = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            digit1 = i >= 0 ? num1[i] - '0' : 0; 
            digit2 = j >= 0 ? num2[j] - '0' : 0; 
            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            ans.push_back((sum % 10) + '0'); 
            i--; 
            j--;
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};
```
