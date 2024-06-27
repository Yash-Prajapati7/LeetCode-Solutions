Leetcode Question : https://leetcode.com/problems/sum-of-two-integers/
## Recuresive approach
Time complexity : O(log max(a,b))<br>
Space complexity : O(log max(a,b))
```java
class Solution {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        return getSum(a ^ b, (a & b)<<1);
    }
}
```
## Iterative approach
Time complexity : O(log max(a,b))<br>
Space complexity : O(1)
```java
class Solution {
    public int getSum(int a, int b) {
      while(b != 0) {
        int temp = (a & b) << 1;
        a = a ^ b;
        b = temp;
      }
      return a;
  }
}
```
