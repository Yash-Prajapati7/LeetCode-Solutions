/*
Leetcode Question :
https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
*/
#include<iostream>
using namespace std;

bool areNumbersAscending(string s) {
    int n = s.size();
    int lastNumber = -1, current = 0;
    bool isNumber = false;

    for(int i = 0; i < n; i++) {
        if(s[i] >= '0' && s[i] <= '9') {
            current = current * 10 + (s[i] - '0');
            isNumber = true;
        } else if(isNumber) {
            if(current <= lastNumber) {
                return false;
            }
            lastNumber = current;
            current = 0;
            isNumber = false;
        }
    }
    // Check the last number if the string ends with a number
    /*
    If we dont put this check than the test-case "abced3bege1"
    will provide incorrect answer
    */
    if(isNumber && current <= lastNumber) {
        return false;
    }

    return true;
}

int main() {
    cout << areNumbersAscending("10 20 30");
    return 0;
}
