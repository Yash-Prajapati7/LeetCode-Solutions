Leetcode Question : [Four Divisors](https://leetcode.com/problems/four-divisors/)

### Java

```java
class Solution {
    public int sumFourDivisors(int[] nums) {
        int[] divisors = new int[100001];
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(divisors[num] != 0) {
                result += divisors[num];
            }
            else {
                int count = 2;  // 1 and num itself are always going to be the divisors
                int sum = num + 1;
                
                for(int j = 2; j <= num >> 1; j++) {
                    if(num % j == 0) {
                        count++;
                        sum += j;
                    }
                    if(count > 4) {
                        break;
                    }
                }

                if(count == 4) {
                    divisors[num] = sum;
                    result += sum;                    
                }
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
public:
    int sumFourDivisors(vector<int>& nums) {
        vector<int> divisors(100001, 0);
        int result = 0;

        for(int i = 0; i < nums.size(); i++) {
            int num = nums[i];

            if(divisors[num] != 0) {
                result += divisors[num];
            }
            else {
                int count = 2;  // 1 and num itself are always going to be the divisors
                int sum = num + 1;

                for(int j = 2; j <= (num >> 1); j++) {
                    if(num % j == 0) {
                        count++;
                        sum += j;
                    }
                    if(count > 4) {
                        break;
                    }
                }

                if(count == 4) {
                    divisors[num] = sum;
                    result += sum;
                }
            }
        }

        return result;
    }
};
```
