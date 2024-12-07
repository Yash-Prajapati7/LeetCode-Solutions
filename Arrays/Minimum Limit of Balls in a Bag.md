Leetcode Question : [Minimum Limit of Balls in a Bag](https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/)

### Java
```java
class Solution {
    private boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
        int total = 0;

        for(int num : nums) {
            total = total + ((num + maxBallsInBag - 1) / maxBallsInBag) - 1; // Ceil division
            if(total > maxOperations) return false;
        }

        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max = -1;
        for(int num : nums) {
            max = num > max ? num : max;
        }

        int left = 1, right = max;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(isPossible(mid, nums, maxOperations)) {
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

### C++
```cpp
class Solution {
private:
    bool isPossible(int maxBallsInBag, vector<int>& nums, int maxOperations) {
        int total = 0;

        for(int num : nums) {
            total += ((num + maxBallsInBag - 1) / maxBallsInBag) - 1; // Ceil division
            if(total > maxOperations) return false;
        }

        return true;
    }
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int max = -1;
        for(int num : nums) {
            max = num > max ? num : max;
        }

        int left = 1, right = max;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(isPossible(mid, nums, maxOperations)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
};
```
