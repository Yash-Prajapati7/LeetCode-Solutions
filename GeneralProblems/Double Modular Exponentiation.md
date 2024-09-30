Leetcode Question : [Double Modular Exponentiation](https://leetcode.com/problems/double-modular-exponentiation/)

```java
public class Solution {
    // Function to perform modular exponentiation (a^b % mod)
    public long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1; // exp /= 2
            base = (base * base) % mod;
        }
        return result;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> goodIndices = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            
            // Compute (a^b % 10)
            long firstModExp = modExp(a, b, 10);
            
            // Compute ((a^b % 10)^c % m)
            long result = modExp(firstModExp, c, m);
            
            // Check if result matches the target
            if (result == target) {
                goodIndices.add(i);
            }
        }
        return goodIndices;
    }
}
```
