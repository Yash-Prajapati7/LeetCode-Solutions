Leetcode Question : [Power of Three](https://leetcode.com/problems/power-of-three/)

## Approach - 1
```java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }

        while(n > 0) {
            if(n == 1) {
                return true;
            }
            else if(n % 2 == 0) {
                return false;
            }
            else {
                n /= 3;
            }
        }
        
        return false;
    }
}
```

## Approach - 2
```java
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0; 
    }
}
```
