Leetcode Question : [Count Pair Of Similar Strings](https://leetcode.com/problems/count-pairs-of-similar-strings/)
## Method - 1 (Brute Force)
### Java
```java
class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            HashSet<Character> word1 = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                word1.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                HashSet<Character> word2 = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    word2.add(c);
                }
                if (word1.equals(word2)) {
                    count++;
                }
            }
        }
        return count;
    }
}
```
### C++
```cpp
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int similarPairs(vector<string>& words) {
        int count = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            unordered_set<char> word1;
            for (char c : words[i]) {
                word1.insert(c);
            }
            for (int j = i + 1; j < words.size(); j++) {
                unordered_set<char> word2;
                for (char c : words[j]) {
                    word2.insert(c);
                }
                if (word1 == word2) {
                    count++;
                }
            }
        }
        return count;
    }
};
```
## Method - 2 (Optimal)
### Java
```java
class Solution {
    public int similarPairs(String[] words) {
        HashMap<Integer, Integer> bitmaskCount = new HashMap<>();
        int count = 0;

        // Calculate the bitmask for each word and update the count in the HashMap
        for (String word : words) {
            int bitmask = 0;
            for (char c : word.toCharArray()) {
                bitmask |= (1 << (c - 'a'));
            }
            bitmaskCount.put(bitmask, bitmaskCount.getOrDefault(bitmask, 0) + 1);
        }

        // Calculate the number of similar pairs
        for (int freq : bitmaskCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2;
            }
        }

        return count;
    }
}
```
### C++
```cpp
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int similarPairs(vector<string>& words) {
        unordered_map<int, int> bitmaskCount;
        int count = 0;

        // Calculate the bitmask for each word and update the count in the unordered_map
        for (const string& word : words) {
            int bitmask = 0;
            for (char c : word) {
                bitmask |= (1 << (c - 'a'));
            }
            bitmaskCount[bitmask]++;
        }

        // Calculate the number of similar pairs
        for (const auto& pair : bitmaskCount) {
            int freq = pair.second;
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2;
            }
        }

        return count;
    }
};
```
