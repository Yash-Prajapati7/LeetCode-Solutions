Leetcode Question : [Total Distance Traveled](https://leetcode.com/problems/total-distance-traveled/description/)

## Method - 1
```java
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance = 0;
        while(mainTank > 0) {
            if(mainTank >= 5) {
                distance += 50;
                if(additionalTank-- > 0) {
                    mainTank -= 4; // mainTank -= 5 + 1(additionalTank)
                }
                else {
                    mainTank -= 5;
                }
            }
            else {
                distance += mainTank * 10;
                mainTank = 0;
            }
        }
        return distance;
    }
}
```

## Method - 2
```java
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return (mainTank + Math.min((mainTank - 1) / 4, additionalTank)) * 10;
    }
}
```
