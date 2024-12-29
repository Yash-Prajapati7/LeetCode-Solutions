 LeetCode Question: [Sort Vowels in a String](https://leetcode.com/problems/sort-vowels-in-a-string/)

### Java
```java
class Solution {
    int[] freq = new int[10];
    private void isVowel(char ch, int idx, ArrayList<Integer> pos){
        switch(ch){
            case 'A': freq[0]++; pos.add(idx); break;
            case 'E': freq[1]++; pos.add(idx); break;
            case 'I': freq[2]++; pos.add(idx); break;
            case 'O': freq[3]++; pos.add(idx); break;
            case 'U': freq[4]++; pos.add(idx); break;
            case 'a': freq[5]++; pos.add(idx); break;
            case 'e': freq[6]++; pos.add(idx); break;
            case 'i': freq[7]++; pos.add(idx); break;
            case 'o': freq[8]++; pos.add(idx); break;
            case 'u': freq[9]++; pos.add(idx); break;
        }
    }

    public String sortVowels(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        ArrayList<Integer> pos = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            isVowel(c[i], i, pos);
        }

        int count = 0, v = freq[0], j = 0;
        for(int i : pos) {
            while(v <= count) {
                v += freq[++j];
            }
            c[i] = vowels[j];
            count++;
        }

        return new String(c);
    }
}
```

### C++
```cpp
class Solution {
    int freq[10] = {0};
    
    void isVowel(char ch, int idx, vector<int>& pos) {
        switch(ch) {
            case 'A': freq[0]++; pos.push_back(idx); break;
            case 'E': freq[1]++; pos.push_back(idx); break;
            case 'I': freq[2]++; pos.push_back(idx); break;
            case 'O': freq[3]++; pos.push_back(idx); break;
            case 'U': freq[4]++; pos.push_back(idx); break;
            case 'a': freq[5]++; pos.push_back(idx); break;
            case 'e': freq[6]++; pos.push_back(idx); break;
            case 'i': freq[7]++; pos.push_back(idx); break;
            case 'o': freq[8]++; pos.push_back(idx); break;
            case 'u': freq[9]++; pos.push_back(idx); break;
        }
    }
    
public:
    string sortVowels(string s) {
        int n = s.length();
        vector<char> c(s.begin(), s.end());
        vector<char> vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        vector<int> pos;
        
        for (int i = 0; i < n; i++) {
            isVowel(c[i], i, pos);
        }
        
        int count = 0, v = freq[0], j = 0;
        for (int i : pos) {
            while (v <= count) {
                v += freq[++j];
            }
            c[i] = vowels[j];
            count++;
        }
        
        return string(c.begin(), c.end());
    }
};
```
