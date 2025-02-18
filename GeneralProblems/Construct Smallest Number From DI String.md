Leetcode Question : [Construct Smallest Number From DI String](https://leetcode.com/problems/construct-smallest-number-from-di-string/)

```java
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder ans = new StringBuilder(n + 1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++) {
            st.push(i + 1);
            if(i == n || pattern.charAt(i) == 'I') {
                while(!st.isEmpty()) {
                    ans.append(st.pop());
                }
            }
        }

        return new String(ans);
    }
}
```
