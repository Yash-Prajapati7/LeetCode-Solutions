Leetcode Question : [Binary Gap](https://leetcode.com/problems/binary-gap/)

## Method - 1

### Java

```java
class Solution {
    public int binaryGap(int n) {
        // First check whether the number is a power of 2
        for(int i = 0; i < 31; i++) {
            if(1 << i == n) {
                return 0;
            }
        }

        // if not a power of 2 than move ahead
        boolean firstOne = false;
        int ans = 0, current = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                current = 1;
                if(!firstOne) firstOne = true;
            }
            else if(firstOne) {
                current++;
            }
            ans = ans < current ? current : ans;
            n >>= 1;
        }
        return ans;
    }
}
```

## Method - 2

### Java

```java
class Solution {
    public int binaryGap(int n) {
        int current = Integer.MIN_VALUE, ans = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ans = ans < current ? current : ans;
                current = 0;
            }
            current++;
            n >>= 1;
        }
        return ans;
    }
}
```
