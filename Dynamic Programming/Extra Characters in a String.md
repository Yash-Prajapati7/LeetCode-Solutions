Leetcode Question : [Extra Characters in a String](https://leetcode.com/problems/extra-characters-in-a-string/)

```java
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        HashSet<String> dict = new HashSet<>(dictionary.length);
        for(String str : dictionary) {
            dict.add(str);
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for(int j = i; j >= 1; j--) {
                if(dict.contains(s.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[j - 1], dp[i]);
                }
            }
        }
        return dp[n];
    }
}
```
