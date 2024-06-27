LeetCode Question: https://leetcode.com/problems/climbing-stairs/

Here I have used the Binet's Formula for finding the n-th term in fibonacci sequence which you can easily find it on Google.
As per the problem statement given, the number of ways we can climb the stairs is the n+1-th term in the sequence, thus in the formula 'n' is replaced by 'n+1'.

```java
public class ClimbingStairs {
    public static int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double numerator = Math.pow((1 + sqrt5), n + 1) - Math.pow((1 - sqrt5), n + 1);
        return (int) ((numerator) / (Math.pow(2, n + 1) * sqrt5));
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(33));
    }
}
