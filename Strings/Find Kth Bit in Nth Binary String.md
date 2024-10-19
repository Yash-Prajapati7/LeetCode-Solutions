Leetcode Question : [Find Kth Bit in Nth Binary String](https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/)

### Java
```java
class Solution {

    public char findKthBit(int n, int k) {
        if (k == 1 || n == 1) {
            return '0';
        }
        int length = (1 << n) - 1;
        int invertCount = 0;

        while (k > 1) {
            if (k == length / 2 + 1) {
                return invertCount % 2 == 0 ? '1' : '0';
            }

            if(k > length / 2) {
                k = length - k + 1;
                invertCount++;
            }

            length /= 2;
        }

         return invertCount % 2 == 0 ? '0' : '1';
    }
}
```

### C++
```cpp
class Solution {
public:
    char findKthBit(int n, int k) {
        if (k == 1 || n == 1) {
            return '0';
        }
        int length = (1 << n) - 1;
        int invertCount = 0;

        while (k > 1) {
            if (k == length / 2 + 1) {
                return invertCount % 2 == 0 ? '1' : '0';
            }

            if (k > length / 2) {
                k = length - k + 1;
                invertCount++;
            }

            length /= 2;
        }

        return invertCount % 2 == 0 ? '0' : '1';
    }
};
```
