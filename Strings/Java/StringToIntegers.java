/*
Leetcode Question :
https://leetcode.com/problems/string-to-integer-atoi/description/
*/
public class StringToIntegers {
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0, sign = 1, total = 0;

        // Remove leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Check if the string is empty after removing whitespaces
        if (index == s.length()) {
            return 0;
        }

        // Check for the sign
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Convert to integer and handle overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break; // Not a valid digit
            }

            // Check for overflow
            if (total > Integer.MAX_VALUE / 10 ||
                    (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
