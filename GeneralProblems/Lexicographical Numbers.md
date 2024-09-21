Leetcode Question : [Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/)

```java
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int i = 0, current = 1;
        while(i < n) {
            res.add(current);
            if(current * 10 <= n) {
                current *= 10;
            }
            else {
                while(current == n || current % 10 == 9) {
                    current /= 10;
                }
                current++;
            }
            i++;
        }
        return res;
    }
}
```
