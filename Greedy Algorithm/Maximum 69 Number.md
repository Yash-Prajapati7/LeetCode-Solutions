Leetcode Question : [Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)

```java
class Solution {
    public int maximum69Number(int num) {
        String s = num + "";
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '9') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
```
