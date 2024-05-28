/*
Leetcode Question :
https://leetcode.com/problems/valid-anagram/description/
*/
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        // Build the frequency map for the first string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hm.put(c, hm.get(c) + 1);
        }

        // Decrease the frequency based on the second string
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!hm.containsKey(c)) {
                return false;
            }
            hm.put(c, hm.get(c) - 1);
            if (hm.get(c) == 0) {
                hm.remove(c);  // Clean up to keep the map size small
            }
        }
        return hm.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two strings: ");
        String s = sc.next();
        String t = sc.next();
        System.out.println(isAnagram(s, t));
    }
}
