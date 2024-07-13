Leetcode Question : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
### Java
```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int maxScore = 0;

        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int rightIndex = cardPoints.length - 1;
        int rightSum = 0;
        maxScore = leftSum;

        for(int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex];
            maxScore = Math.max(maxScore, leftSum + rightSum);
            rightIndex--;
        }
        return maxScore;
    }
}
```
### C++
```cpp
class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int leftSum = 0;
        int maxScore = 0;

        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int rightIndex = cardPoints.size() - 1;
        int rightSum = 0;
        maxScore = leftSum;

        for(int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex];
            maxScore = max(maxScore, leftSum + rightSum);
            rightIndex--;
        }
        return maxScore;
    }
};

```
