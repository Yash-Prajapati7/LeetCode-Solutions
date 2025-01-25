Leetcode Question : [Construct the Rectangle](https://leetcode.com/problems/construct-the-rectangle/)

```java
class Solution {
    public int[] constructRectangle(int area) {
        for (int w = (int) Math.sqrt(area); w > 0; w--) {
            if (area % w == 0) {
                return new int[] {area / w, w};
            }
        }
        return new int[] {-1, -1};
    }
}
```
