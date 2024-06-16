/*
LeetCode Question:
https://leetcode.com/problems/zigzag-conversion/
*/
#include <iostream>
#include <vector>
#include <string>

using namespace std;

class ZigZagConversion {
public:
    string convert(const string& s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        vector<string> rows(numRows);
        int currentRow = 0;
        bool goingDown = false;

        for (char c : s) {
            rows[currentRow] += c;
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        string result;
        for (const string& row : rows) {
            result += row;
        }

        return result;
    }
};

int main() {
    ZigZagConversion solution;
    string s = "PAYPALISHIRING";
    int numRows = 3;
    cout << solution.convert(s, numRows) << endl; 
    return 0;
}
