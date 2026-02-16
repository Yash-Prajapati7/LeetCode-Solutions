Leetcode Question : [Reverse Bits](https://leetcode.com/problems/reverse-bits/)

## Approach - 1 (Using string methods)

### Java

```java
class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        
        StringBuilder binaryNumber = new StringBuilder(Integer.toBinaryString(n));
        int binaryNumberLength = binaryNumber.length();

        String reversedBinaryNumber = binaryNumber.reverse().toString();
    
        int result = Integer.parseInt(reversedBinaryNumber, 2);
        return result << (32 - binaryNumberLength);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int reverseBits(int n) {
        if(n == 0) return 0;
        
        string binaryNumber = "";
        int temp = n;
        
        while(temp > 0) {
            binaryNumber.push_back((temp % 2) + '0');
            temp /= 2;
        }
        
        int binaryNumberLength = binaryNumber.length();
        reverse(binaryNumber.begin(), binaryNumber.end());
        
        int result = 0;
        for(char c : binaryNumber) {
            result = result * 2 + (c - '0');
        }
        
        return result << (32 - binaryNumberLength);
    }
};
```

## Approach - 2 (using math operations)

### Java

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;

        // Process all 32 bits
        for (int i = 0; i < 32; i++) {
            // Extract last bit of n
            int bit = n & 1;
            
            // Shift result left and add extracted bit
            result = (result << 1) | bit;
            
            // Unsigned right shift n to process next bit
            n = n >>> 1;
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
    int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            result = (result << 1) | bit;
            n = (unsigned int)n >> 1;
        }

        return result;
    }
};
```
