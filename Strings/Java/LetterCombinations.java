/*
Leetcode Question :
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private String[] letterMap = {
            "",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    private ArrayList<String> combinations;

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.equals("")) {
            return combinations;
        }
        dfs(digits, 0, new StringBuilder());
        return combinations;
    }

    private void dfs(String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }
        // Get the current digit
        char c = digits.charAt(index);
        // Get the letters corresponding to the digit
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // Append current letter to the combination
            current.append(letters.charAt(i));
            // Recur for the next digit
            dfs(digits, index + 1, current);
            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "234";
        List<String> result = letterCombinations.letterCombinations(digits);
        System.out.println(result);  // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
