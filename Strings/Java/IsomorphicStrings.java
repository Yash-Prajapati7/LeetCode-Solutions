/*
Leetcode Question :
https://leetcode.com/problems/isomorphic-strings/
*/
import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;  // Lengths must be the same
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;  // Existing mapping does not match
                }
            } else {
                mapST.put(charS, charT);  // Create new mapping
            }

            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;  // Existing reverse mapping does not match
                }
            } else {
                mapTS.put(charT, charS);  // Create new reverse mapping
            }
        }
        return true;  // All character mappings are consistent
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }
}
