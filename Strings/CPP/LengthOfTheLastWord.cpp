/*
LeetCode Question:
https://leetcode.com/problems/length-of-last-word/
*/
#include <iostream>
#include <string>

using namespace std;

int lengthOfLastWord(string str) {
    // Trim trailing spaces
    while (!str.empty() && str[str.length() - 1] == ' ') {
        str.pop_back();
    }

    int length = 0;
    for (int i = str.length() - 1; i >= 0; --i) {
        if (str[i] == ' ') {
            break;
        }
        length++;
    }

    // Return the length of the last word
    return length;
}

int main() {
    cout << lengthOfLastWord("   Hello World   ") << endl;
    return 0;
}
