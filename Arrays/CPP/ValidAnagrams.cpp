/*
Leetcode Question :
https://leetcode.com/problems/valid-anagram/description/
*/
#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

bool isAnagram(const string &s, const string &t) {
    unordered_map<char, int> hm;

    if (s.length() != t.length()) {
        return false;
    }

    // Build the frequency map for the first string
    for (int i = 0; i < s.length(); ++i) {
        if (hm.find(s[i]) != hm.end()) {
            hm[s[i]]++;
        } else {
            hm[s[i]] = 1;
        }
    }

    // Decrease the frequency based on the second string
    for (int i = 0; i < t.length(); ++i) {
        if (hm.find(t[i]) != hm.end()) {
            hm[t[i]]--;
        }
    }

    // Check the frequencies
    for (int i = 0; i < s.length(); ++i) {
        if (hm[s[i]] != 0) {
            return false;
        }
    }

    return true;
}

int main() {
    string s, t;
    cout << "Enter the two strings: ";
    cin >> s >> t;
    cout << (isAnagram(s, t) ? "true" : "false") << endl;
    return 0;
}
