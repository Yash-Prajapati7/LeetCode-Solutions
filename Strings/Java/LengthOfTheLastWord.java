/*
LeetCode Question:
https://leetcode.com/problems/length-of-last-word/
*/
public class LengthOfTheLastWord {
    public static int lengthOfLastWord(String s) {
        // Trim any leading or trailing whitespace
        s = s.trim();

        // Find the last space after trimming
        int lastSpaceIndex = s.lastIndexOf(' ');

        // Return the length of the last word
        return s.length() - lastSpaceIndex - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));     
    }
}
