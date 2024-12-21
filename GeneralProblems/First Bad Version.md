Leetcode Question: [First Bad Version](https://leetcode.com/problems/first-bad-version/)

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid = 1;

        while(left < right) {
            mid = left + ((right - left) >> 1);
            if(isBadVersion(mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```
