Leetcode Question : [2 Keys Keyboard](https://leetcode.com/problems/2-keys-keyboard/)

### Java
```java
class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        
        int operations = 0;
        int factor = 2;
        
        while (n > 1) {
            while (n % factor == 0) {
                operations += factor;
                n /= factor;
            }
            factor++;
        }
        
        return operations;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minSteps(int n) {
        if (n == 1) return 0;
        
        int operations = 0;
        int factor = 2;
        
        while (n > 1) {
            while (n % factor == 0) {
                operations += factor;
                n /= factor;
            }
            factor++;
        }
        
        return operations;
    }
};
```
