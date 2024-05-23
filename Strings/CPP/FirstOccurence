//Leetcode Problem :
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
#include<iostream>
#include<string.h>
using namespace std;
int strStr(string haystack, string needle) {
    if (needle.length() > haystack.length()) {
            return -1;
        }
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack[i] != needle[j]) {
                i = i - j + 1; // Move back to the next starting point in haystack
                j = 0;
            } else {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // Found the needle, return the start index
                }
            }
        }
    return -1;
}

int main() {
    cout<<strStr("mississippi", "issip");
}
