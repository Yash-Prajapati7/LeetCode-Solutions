Leetcode Question : [Bitwise XOR of All Pairings](https://leetcode.com/problems/bitwise-xor-of-all-pairings/)

## Method - 1 (Brute Force)

### Java
```java
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                xor ^= (num1 ^ num2);
            }
        }
        return xor;
    }
}
```

### C++
```cpp
class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int xorValue = 0;
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                xorValue ^= (num1 ^ num2);
            }
        }
        return xorValue;
    }
};
```

## Method - 2 (Optimized Approach)

### Java
```java
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n2 % 2 != 0) {
            for(int num : nums1) xor ^= num;
        }

        if(n1 % 2 != 0) {
            for(int num : nums2) xor ^= num;
        }

        return xor;
    }
}
```

### C++
```cpp
class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int xorValue = 0;
        int n1 = nums1.size();
        int n2 = nums2.size();

        if(n2 % 2 != 0) {
            for(int num : nums1) xorValue ^= num;
        }

        if(n1 % 2 != 0) {
            for(int num : nums2) xorValue ^= num;
        }

        return xorValue;
    }
};
```
