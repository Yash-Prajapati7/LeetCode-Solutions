Leetcode Question : [Convert Integer to the Sum of Two No-Zero Integers](https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/)

### Java

```java
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int num1 = 1, num2 = n - 1;
        while(true) {
            int temp1 = num1, temp2 = num2;
            boolean zeroNumber = false;
            
            while(temp1 > 0) {
                if(temp1 % 10 == 0) {
                    num1++;
                    num2--;
                    zeroNumber = true;
                    break;
                }

                temp1 /= 10;
            }

            while(temp2 > 0) {
                if(temp2 % 10 == 0) {
                    num1++;
                    num2--;
                    zeroNumber = true;
                    break;
                }

                temp2 /= 10;
            }

            if(!zeroNumber) {
                return new int[] {num1, num2};
            }
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        int num1 = 1, num2 = n - 1;
        while(true) {
            int temp1 = num1, temp2 = num2;
            bool zeroNumber = false;
            
            while(temp1 > 0) {
                if(temp1 % 10 == 0) {
                    num1++;
                    num2--;
                    zeroNumber = true;
                    break;
                }
                temp1 /= 10;
            }

            while(temp2 > 0) {
                if(temp2 % 10 == 0) {
                    num1++;
                    num2--;
                    zeroNumber = true;
                    break;
                }
                temp2 /= 10;
            }

            if(!zeroNumber) {
                return {num1, num2};
            }
        }
    }
};
```
