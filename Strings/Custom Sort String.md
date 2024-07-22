Leetcode Question : [Custom Sort String](https://leetcode.com/problems/custom-sort-string/description/)
### Java
```java
class Solution {
    public String customSortString(String order, String s) {
        // Create a frequency map for characters in s
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        // Build the result string based on the order
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (charFreq.containsKey(c)) {
                int count = charFreq.get(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                charFreq.remove(c);
            }
        }

        // Append remaining characters that were not in order
        for (char c : charFreq.keySet()) {
            int count = charFreq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
```
### C++
```cpp
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string customSortString(string order, string s) {
        // Create a frequency map for characters in s
        unordered_map<char, int> charFreq;
        for (char c : s) {
            charFreq[c]++;
        }

        // Build the result string based on the order
        string result;
        for (char c : order) {
            if (charFreq.find(c) != charFreq.end()) {
                int count = charFreq[c];
                result.append(count, c);
                charFreq.erase(c);
            }
        }

        // Append remaining characters that were not in order
        for (const auto& pair : charFreq) {
            result.append(pair.second, pair.first);
        }

        return result;
    }
};
```
