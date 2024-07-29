Leetcode Question : [Assign Cookies](https://leetcode.com/problems/assign-cookies/description/)
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;  // pointer to array 'g'
        int j = 0;  // pointer to array 's'
        int count = 0;
        while(i != g.length && j != s.length) {
            if(g[i] <= s[j]) {
                count++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
```
