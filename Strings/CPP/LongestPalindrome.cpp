/*
Leetcode Qeustion : 
https://leetcode.com/problems/longest-palindrome/description/
*/

#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int longestPalindrome(const string& s) {
    unordered_map<char, int> hm;

    // Count the occurrences of each character
    for (char c : s) {
        hm[c]++;
    }

    int length = 0;
    bool hasOdd = false;

    // Calculate the length of the longest palindrome
    for (const auto& entry : hm) {
        int count = entry.second;
        if (count % 2 == 0) {
            length += count; // If even, add the whole count
        } else {
            length += count - 1; // If odd, add the largest even number less than count
            hasOdd = true; // Remember there is at least one odd count
        }
    }

    if (hasOdd) {
        length += 1; // Add one center character if there was an odd count
    }

    return length;
}

int main() {
    string s = "Abcd";
    cout << longestPalindrome(s) << endl;
    return 0;
}
