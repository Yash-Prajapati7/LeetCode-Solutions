// Leetcode Question : https://leetcode.com/problems/isomorphic-strings/
#include <iostream>
#include <unordered_map>
using namespace std;

bool isIsomorphic(string s, string t) {
    if (s.length() != t.length()) {
        return false;  // Lengths must be the same
    }

    unordered_map<char, char> mapST;
    unordered_map<char, char> mapTS;

    for (int i = 0; i < s.length(); i++) {
        char charS = s[i];
        char charT = t[i];

        if (mapST.find(charS) != mapST.end()) {
            if (mapST[charS] != charT) {
                return false;  // Existing mapping does not match
            }
        } else {
            mapST[charS] = charT;  // Create new mapping
        }

        if (mapTS.find(charT) != mapTS.end()) {
            if (mapTS[charT] != charS) {
                return false;  // Existing reverse mapping does not match
            }
        } else {
            mapTS[charT] = charS;  // Create new reverse mapping
        }
    }
    return true;  // All character mappings are consistent
}

int main() {
    string s = "foo";
    string t = "bar";
    cout << boolalpha << isIsomorphic(s, t) << endl;
    return 0;
}
