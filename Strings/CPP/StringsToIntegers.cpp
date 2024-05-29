/*
Leetcode Question :
https://leetcode.com/problems/string-to-integer-atoi/description/
*/
#include <iostream>
#include <string>
#include <climits>

using namespace std;

class StringToIntegers {
public:
    static int myAtoi(const string& s) {
        if (s.empty()) {
            return 0;
        }

        int index = 0, sign = 1, total = 0;

        // Remove leading whitespaces
        while (index < s.length() && s[index] == ' ') {
            index++;
        }

        // Check if the string is empty after removing whitespaces
        if (index == s.length()) {
            return 0;
        }

        // Check for the sign
        if (s[index] == '-') {
            sign = -1;
            index++;
        }

        // Convert to integer and handle overflow
        while (index < s.length()) {
            char currentChar = s[index];
            if (currentChar < '0' || currentChar > '9') {
                break; // Not a valid digit
            }
            int digit = currentChar - '0';

            // Check for overflow
            if (total > INT_MAX / 10 || (total == INT_MAX / 10 && digit > INT_MAX % 10)) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
};

int main() {
    cout << StringToIntegers::myAtoi("   -42") << endl;           // Output: -42
    cout << StringToIntegers::myAtoi("4193 with words") << endl;  // Output: 4193
    cout << StringToIntegers::myAtoi("words and 987") << endl;    // Output: 0
    cout << StringToIntegers::myAtoi("-91283472332") << endl;     // Output: -2147483648

    return 0;
}
