/*
Leetcode Problem :
https://leetcode.com/problems/valid-parentheses/
*/
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Enter a String:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        // Check if the input string has valid parentheses
        System.out.println(isValid(s) ? "True" : "False");
    }

    public static boolean isValid(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // If the character is a closing bracket
            else if (c == ')' || c == ']' || c == '}') {
                // If the stack is empty, there's no corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack
                char top = stack.pop();
                // Check if the popped element matches the current closing bracket
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets had matching closing brackets
        return stack.isEmpty();
    }

    // Helper method to check if the pair of brackets match
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}

