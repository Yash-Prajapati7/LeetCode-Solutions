Leetcode Question : [Find Greatest Common Divisor of Array](https://leetcode.com/problems/find-greatest-common-divisor-of-array/)  

### Java
```java
class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int findGCD(int[] nums) {
        int min = 10001, max = -1;
        for(int num : nums) {
            if(num < min) min = num;
            if(num > max) max = num;
        }
        return gcd(max, min);
    }
}
```

### C++
```cpp
class Solution {
private:
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
public:
    int findGCD(vector<int>& nums) {
        int min = 10001, max = -1;
        for(int num : nums) {
            if(num < min) min = num;
            if(num > max) max = num;
        }
        return gcd(max, min);
    }
};
```
