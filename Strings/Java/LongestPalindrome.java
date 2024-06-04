/*
Leetcode Qeustion : 
https://leetcode.com/problems/longest-palindrome/description/
*/
import java.util.HashMap;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        // Count the occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        // Calculate the length of the longest palindrome
        for (int count : hm.values()) {
            if (count % 2 == 0) {
                length += count; // If even, add the whole count
            } else {
                length += count - 1; // If odd, add the largest even number less than count
                hasOdd = true; // Remember there is at least one odd count
            }
        }

        if (hasOdd) {
            length += 1; // Add one center character if there was an odd count
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "Abcd";
        System.out.println(longestPalindrome(s));
    }
}
