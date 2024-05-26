/*
Leetcode Question :
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/
#include <iostream>
#include <vector>
#include <string>

using namespace std;

class LetterCombinations {
private:
    vector<string> letterMap = {
        " ",    // 0
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
    vector<string> combinations;

public:
    vector<string> letterCombinations(string digits) {
        combinations.clear();
        if (digits.empty()) {
            return combinations;
        }
        dfs(digits, 0, "");
        return combinations;
    }

private:
    void dfs(const string& digits, int index, string current) {
        if (index == digits.length()) {
            combinations.push_back(current);
            return;
        }
        // Get the current digit
        char c = digits[index];
        // Get the letters corresponding to the digit
        string letters = letterMap[c - '0'];
        for (char letter : letters) {
            // Append current letter to the combination
            dfs(digits, index + 1, current + letter);
        }
    }
};

int main() {
    LetterCombinations letterCombinations;
    string digits = "23";
    vector<string> result = letterCombinations.letterCombinations(digits);
    for (const string& combination : result) {
        cout << combination << " ";
    }
    // Output: ad ae af bd be bf cd ce cf
    cout << endl;
    return 0;
}
