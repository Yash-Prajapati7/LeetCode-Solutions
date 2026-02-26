Leetcode Question : [Number of Steps to Reduce a Number in Binary Representation to One](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/)

## Method - 1 (Simulation)

### Java

```java
class Solution {
    private StringBuilder addOne(StringBuilder sb) {
        int i = sb.length() - 1;
        boolean carry = true;

        while (i >= 0 && carry) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                carry = false;
            } else {
                sb.setCharAt(i, '0');
            }
            i--;
        }

        if (carry) {
            sb.insert(0, '1');
        }

        return sb;
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = 2;
        int steps = 0;

        while (n > 1) {
            n = sb.length();
            if (sb.charAt(n - 1) == '0') {
                sb.setLength(n - 1);
            } else {
                sb = addOne(sb);
            }
            steps++;
        }

        return steps - 1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    string addOne(string sb) {
        int i = sb.length() - 1;
        bool carry = true;

        while (i >= 0 && carry) {
            if (sb[i] == '0') {
                sb[i] = '1';
                carry = false;
            } else {
                sb[i] = '0';
            }
            i--;
        }

        if (carry) {
            sb = "1" + sb;
        }

        return sb;
    }

public:
    int numSteps(string s) {
        string sb = s;
        int n = 2;
        int steps = 0;

        while (n > 1) {
            n = sb.length();
            if (sb[n - 1] == '0') {
                sb.pop_back();
            } else {
                sb = addOne(sb);
            }
            steps++;
        }

        return steps - 1;
    }
};
```

## Method - 2 (Greedy)

### Java

```java
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Traverse from right to left (excluding MSB)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {
                // odd → add 1 then divide
                steps += 2;
                carry = 1;
            } else {
                // even → divide
                steps += 1;
            }
        }

        // If carry remains at MSB
        return steps + carry;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numSteps(string s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s[i] - '0') + carry;

            if (bit == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
};
```
