Leetcode Question : [Find Words Containing a Given Letter](https://leetcode.com/problems/find-words-containing-a-given-letter/)
### Java
```java
class Solution {
    private boolean contains(String word, char x) {
        int length = word.length();
        for(int i = 0; i < length; i++) {
            if(word.charAt(i) == x) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for(String word : words) {
            if(contains(word, x)) {
                result.add(index);
            }
            index++;
        }
        return result;
    }
}
```
### C++
```cpp
class Solution {
private:
    bool contains(const string& word, char x) {
        int length = word.length();
        for(int i = 0; i < length; i++) {
            if(word[i] == x) {
                return true;
            }
        }
        return false;
    }
public:
    vector<int> findWordsContaining(vector<string>& words, char x) {
        vector<int> result;
        int index = 0;
        for(const string& word : words) {
            if(contains(word, x)) {
                result.push_back(index);
            }
            index++;
        }
        return result;
    }
};
```
