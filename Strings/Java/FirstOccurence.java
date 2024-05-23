//Leetcode Problem :
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public int strStr(String haystack, String needle) {
        // Edge case: if needle is longer than haystack, return -1
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                // Move back to the next starting point in haystack
                i = i - j + 1;
                j = 0;
            } else {
                i++;
                j++;
                // If the whole needle is found, return the start index
                if (j == needle.length()) {
                    return i - j;
                }
            }
        }

        // If needle is not found, return -1
        return -1;
    }
