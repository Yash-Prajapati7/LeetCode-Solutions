Leetcode Question : [Count Largest Group](https://leetcode.com/problems/count-largest-group/)

### Java
```java
class Solution {
    public int countLargestGroup(int n) {
        if(n < 10) return n;
        int max = 0;
        int ans = 0;
        List<Integer>[] groups = new ArrayList[37];   // since the max sum can be of the number 9999 i.e 36

        for (int i = 0; i <= 36; i++) {
            groups[i] = new ArrayList<>();
        }
        
        int digitSum = 0, num = 0;
        for(int i = 1; i <= n; i++) {
            digitSum = 0;
            num = i;
            while(num > 0) {
                digitSum += (num % 10);
                num /= 10;
            }
            groups[digitSum].add(i);
            max = groups[digitSum].size() > max ? groups[digitSum].size() : max;
        }

        for(int i = 0; i <= 36; i++) if(groups[i].size() == max) ans++;
        return ans;
    }
}
```
