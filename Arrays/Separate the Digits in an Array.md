Leetcode Question : [Separate the Digits in an Array](https://leetcode.com/problems/separate-the-digits-in-an-array/)

### Java

```java
class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> digits = new ArrayList<>(n << 1);
        int num = 0;
        int[] temp = new int[6];    // max possible number is 1,00,000
        int k = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < 10) {
                digits.add(nums[i]);
            }
            else {
                num = nums[i];
                k = 0;

                while(num > 0) {
                    temp[k++] = num % 10;
                    num /= 10;
                }

                while(k-- > 0) {
                    digits.add(temp[k]);
                }
            }
        }

        int size = digits.size();
        int[] ans = new int[size];

        for(int i = 0; i < size; i++) {
            ans[i] = digits.get(i);
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        int n = nums.size();
        vector<int> digits;
        digits.reserve(n << 1);

        int num = 0;
        int temp[6];    // max possible number is 1,00,000
        int k = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < 10) {
                digits.push_back(nums[i]);
            }
            else {
                num = nums[i];
                k = 0;

                while(num > 0) {
                    temp[k++] = num % 10;
                    num /= 10;
                }

                while(k-- > 0) {
                    digits.push_back(temp[k]);
                }
            }
        }

        return digits;
    }
};
```
