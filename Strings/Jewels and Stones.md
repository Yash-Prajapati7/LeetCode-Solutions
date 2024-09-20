Leetcode Question : [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)

### Method 1 - Brute Force

### Java
```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for(int i = 0; i < stones.length(); i++){
            char ch = stones.charAt(i);
            boolean found = false;
            for(int j = 0; j < jewels.length(); j++){
                char ch1 = jewels.charAt(j);
                if(ch == ch1){
                    found = true;                    
                }            
            }
            if(found == true){
                ans++;
            }
        }
        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        int ans = 0;
        for(int i = 0; i < stones.length(); i++){
            char ch = stones[i];
            bool found = false;
            for(int j = 0; j < jewels.length(); j++){
                char ch1 = jewels[j];
                if(ch == ch1){
                    found = true;
                }
            }
            if(found == true){
                ans++;
            }
        }
        return ans;
    }
};
```

### Method 2 - Better Approach

### Java
```java
import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for(int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            if(freq.containsKey(c)) {
                ans += freq.get(c);
            }
        }

        return ans;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        unordered_map<char, int> freq;
        for(int i = 0; i < stones.length(); i++) {
            char c = stones[i];
            freq[c]++;
        }

        int ans = 0;
        for(int i = 0; i < jewels.length(); i++) {
            char c = jewels[i];
            if(freq.find(c) != freq.end()) {
                ans += freq[c];
            }
        }

        return ans;
    }
};
```
