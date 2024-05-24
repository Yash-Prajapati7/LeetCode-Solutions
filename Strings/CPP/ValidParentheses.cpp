/*
Leetcode Problem :
https://leetcode.com/problems/valid-parentheses/
*/

#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isValid(string s) {
    stack<char> stk;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stk.push(s[i]);
        } else if (s[i] == ')' || s[i] == '}' || s[i] == ']') {
            if (stk.empty()) {
                return false;
            }
            char top = stk.top();
            stk.pop();
            if ((top == '(' && s[i] != ')') || 
                (top == '[' && s[i] != ']') || 
                (top == '{' && s[i] != '}')) {
                return false;
            }
        }
    }
    // If the stack is empty, all opening brackets had matching closing brackets
    return stk.empty();
}

int main() {
    cout << "Enter your string: ";
    string s;
    cin >> s;

    if (isValid(s)) {
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
    
    return 0;
}
