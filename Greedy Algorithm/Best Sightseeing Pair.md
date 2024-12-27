LeetCode Question: [Best Sightseeing Pair](https://leetcode.com/problems/best-sightseeing-pair/)

### Method - 1 (Brute Force, Of course it will hit TLE):
```java
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int current = 0, max = -1;
        int n = values.length;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                current = values[i] + values[j] + i - j;
                max = max < current ? current : max;
            }
        }

        return max;
    }
}
```

### Method - 2:
```java
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int currentLeftScore = 0, max = -1, maxLeftScore = values[0], currentRightScore = 0, temp = 0;
        int n = values.length;

        for(int i = 1; i < n; i++) {
            currentRightScore = values[i] - i;
            temp = maxLeftScore + currentRightScore;
            max = max < temp ? temp : max;

            currentLeftScore = values[i] + i;
            maxLeftScore = maxLeftScore < currentLeftScore ? currentLeftScore : maxLeftScore;
        }

        return max;
    }
}
```
