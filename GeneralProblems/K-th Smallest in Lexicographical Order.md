### Leetcode Question: [K-th Smallest in Lexicographical Order](https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/)

### Method - 1 (Brute Force) (Will cause TLE)
Time Complexity: O(n) <BR>
Space Complexity: O(1)

```java
class Solution {
    public int findKthNumber(int n, int k) {
        if(k == 1) {
            return 1;
        }
        int i = 0;
        int current = 1;
        while(i != n && k-- > 1) {
            if(current * 10 <= n) {
                current *= 10;
            }
            else {
                while(current == n || current % 10 == 9) {
                    current /= 10;
                }
                current++;
            }
        }
        return current;
    }
}
```

### Method - 2 (Efficient Solution)
Time Complexity: O((log n)^2)<BR>
Space Complexity: O(1)

```java
public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;  // Start by subtracting 1 because we start at number 1
        
        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;  // Move to the next prefix
                k -= steps;
            } else {
                curr *= 10;  // Move down to the next level in the tree (add a digit)
                k -= 1;
            }
        }
        return curr;
    }
    
    // Count how many numbers exist between `curr` and `next` in lexicographical order.
    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
```
