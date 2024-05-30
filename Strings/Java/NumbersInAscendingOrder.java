/*
Leetcode Question :
https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
*/

public class Main {
    public static boolean areNumbersAscending(String s) {
        int n = s.length();
        int lastNumber = -1, current = 0;
        boolean isNumber = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                current = current * 10 + (c - '0');
                isNumber = true;
            } else if (isNumber) {
                if (current <= lastNumber) {
                    return false;
                }
                lastNumber = current;
                current = 0;
                isNumber = false;
            }
        }

        // Check the last number if the string ends with a number
        if (isNumber && current <= lastNumber) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("10 20 30"));
    }
}
