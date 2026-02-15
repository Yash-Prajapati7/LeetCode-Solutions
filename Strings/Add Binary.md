Leetcode Question : [Add Binary](https://leetcode.com/problems/add-binary/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        
        StringBuilder sb = new StringBuilder();
        int carry = 0, num1 = 0, num2 = 0;

        if(m < n) {
            while(m != n) {
                a = "0" + a;
                m++;
            }
        } else {
            while(m != n) {
                b = "0" + b;
                n++;
            }
        }

        System.out.print(a + "   " + b);
        int i = m - 1;

        while (i >= 0) {
            num1 = a.charAt(i) - '0';
            num2 = b.charAt(i) - '0';

            if (carry == 0) {
                if (num1 + num2 == 2) {
                    carry = 1;
                    sb.append(0);
                } else if (num1 + num2 == 1) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                if (num1 + num2 == 2) {
                    sb.append(1);
                } else if (num1 + num2 == 1) {
                    sb.append(0);
                } else {
                    carry = 0;
                    sb.append(1);
                }
            }

            i--;
        }

        if(carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        int m = a.length(), n = b.length();
        
        string result = "";
        int carry = 0, num1 = 0, num2 = 0;

        if(m < n) {
            while(m != n) {
                a = "0" + a;
                m++;
            }
        } else {
            while(m != n) {
                b = "0" + b;
                n++;
            }
        }

        cout << a << "   " << b;
        int i = m - 1;

        while (i >= 0) {
            num1 = a[i] - '0';
            num2 = b[i] - '0';

            if (carry == 0) {
                if (num1 + num2 == 2) {
                    carry = 1;
                    result += '0';
                } else if (num1 + num2 == 1) {
                    result += '1';
                } else {
                    result += '0';
                }
            } else {
                if (num1 + num2 == 2) {
                    result += '1';
                } else if (num1 + num2 == 1) {
                    result += '0';
                } else {
                    carry = 0;
                    result += '1';
                }
            }

            i--;
        }

        if(carry == 1) {
            result += '1';
        }

        reverse(result.begin(), result.end());
        return result;
    }
};
```

## Method - 2 (Optimized Approach)

### Java

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string result = "";
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b[j--] - '0';
            if (i >= 0) sum += a[i--] - '0';
            result += char((sum % 2) + '0');
            carry = sum / 2;
        }
        
        if (carry != 0) result += char(carry + '0');
        reverse(result.begin(), result.end());
        return result;
    }
};
```
