Leetcode Question : [Gray Code](https://leetcode.com/problems/gray-code/)

```java
class Solution {
    public List<Integer> grayCode(int n) {    
        n = 1 << n;    // Change n to 2^n
        List<Integer> result = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            result.add(i ^ (i >> 1));   // Formula for finding the gray code of a decimal number(lets say x) is (x ^ (x / 2)) i.e (x [xor] x >> 1)
        }
        return result;
    }
}
```
