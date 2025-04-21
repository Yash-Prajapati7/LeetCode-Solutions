Leetcode Question : [Crawler Log Folder](https://leetcode.com/problems/crawler-log-folder/)

### Java
```java
class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for(String current : logs) {
            if(current.charAt(0) == '.' && current.charAt(1) == '.') {
                if(level > 0) level--;
            }
            else if (current.charAt(0) != '.') level++;
        }

        return level;
    }
}
```
