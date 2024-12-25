Leetcode Question : [Maximum Area of Longest Diagonal Rectangle](https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/)

```java
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = -1, diag = 0;
        int area = 0;
        
        for(int i = 0; i < dimensions.length; i++) {
            diag = Math.sqrt((dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]));
            if(maxDiag < diag) {
                maxDiag = diag;
                area = dimensions[i][0] * dimensions[i][1];
            }
            else if(maxDiag == diag) {
                int newArea = dimensions[i][0] * dimensions[i][1];
                area = newArea > area ? newArea : area;
            }
        }

        return area;
    }
}
```
