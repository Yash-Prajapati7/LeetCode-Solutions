/*
Leetcode Question :
https://leetcode.com/problems/sum-of-square-numbers/
*/
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            long sumOfSquares = (long) left * left + (long) right * right;
            if (sumOfSquares > c) {
                right--;
            } else if (sumOfSquares < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600)); // Should output true
    }
}
