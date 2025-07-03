Leetcode Question : [Find the K-th Character in String Game II](https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/)

## Method - 1 (Brute Force TLE)

### Java

```java
class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k == 1) return 'a';
        StringBuilder word = new StringBuilder("a");
        int len = 0;

        for(int op : operations) {
            switch (op) {
                case 0 :
                    word.append(word);
                    break;
                case 1 :
                    len = word.length();
                    for(int i = 0; i < len; i++) {
                        word.append((char)(word.charAt(i) + 1));
                    }
                    break;
            }
        }

        return word.charAt((int)k - 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char kthCharacter(long long k, vector<int>& operations) {
        if(k == 1) return 'a';
        string word = "a";
        int len = 0;

        for(int op : operations) {
            switch(op) {
                case 0:
                    word += word;
                    break;
                case 1:
                    len = word.length();
                    for(int i = 0; i < len; i++) {
                        word += (char)(word[i] + 1);
                    }
                    break;
            }
        }

        return word[(int)k - 1];
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k == 1) return 'a';
        double log2 = Math.log(2);
        int steps = 0;
        int pow = 0;

        while(k != 1) {
            pow = (int)(Math.log(k) / log2);
            if(1L << pow == k) {
                pow--;
            }
            k = k - (1L << pow);
            if(operations[pow] == 1) {
                steps++;
            }
        }

        return (char)('a' + (steps % 26));
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char kthCharacter(long long k, vector<int>& operations) {
        if(k == 1) return 'a';
        double log2 = log(2);
        int steps = 0, pow = 0;

        while(k != 1) {
            pow = (int)(log(k) / log2);
            if((1LL << pow) == k) {
                pow--;
            }
            k = k - (1LL << pow);
            if(operations[pow] == 1) {
                steps++;
            }
        }

        return (char)('a' + (steps % 26));
    }
};
```
