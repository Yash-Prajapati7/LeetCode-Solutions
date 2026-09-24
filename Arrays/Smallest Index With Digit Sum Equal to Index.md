### Leetcode Question : [Smallest Index With Digit Sum Equal to Index](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)

### Java

```java id="4v8mnp"
class Solution {
    public int smallestIndex(int[] nums) {
        int sum = 0;
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            num = nums[i];

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}
```

### C++

```cpp id="7k2qwf"
using namespace std;

class Solution {
public:
    int smallestIndex(vector<int>& nums) {
        int sum = 0;
        int num = 0;

        for (int i = 0; i < nums.size(); i++) {
            sum = 0;
            num = nums[i];

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
};
```
