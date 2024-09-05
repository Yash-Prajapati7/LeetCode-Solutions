Leetcode Question: [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)

### Java
```java
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *               1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            
            if (result == 0) {
                return mid; // Correct guess
            } else if (result == -1) {
                right = mid - 1; // Guess is too high
            } else {
                left = mid + 1; // Guess is too low
            }
        }
        return -1; // Default return, should not reach here
    }
}
```

### C++
```cpp
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *               1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            
            if (result == 0) {
                return mid; // Correct guess
            } else if (result == -1) {
                right = mid - 1; // Guess is too high
            } else {
                left = mid + 1; // Guess is too low
            }
        }
        return -1; // Default return, should not reach here
    }
};
```
