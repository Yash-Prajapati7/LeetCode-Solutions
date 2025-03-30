Leetcode Question : [Count Symmetric Integers](https://leetcode.com/problems/count-symmetric-integers/)
### Java
```java
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        if(high <= 9) return 0;
        String num = "";
        int n = 0;
        int ptr = 0, sum = 0;
        int ans = 0;
        if(low <= 9) low = 10; 
        if(high >= 101 && high <= 999) high = 100;

        for(int i = low; i <= high; i++) {
            num = String.valueOf(i);
            n = num.length();
            if(n % 2 == 0) {
                ptr = 0;
                sum = 0;
                while(ptr < (n >> 1)) {
                    sum += num.charAt(ptr++);
                }
                while(ptr < n) {
                    sum -= num.charAt(ptr++);
                }

                if(sum == 0) ans++;
            }
        }

        return ans;
    }
}
```
