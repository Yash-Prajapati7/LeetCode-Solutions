Leetcode Question : [Find the K-th Character in String Game I](https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public char kthCharacter(int k) {
        if(k == 1) return 'a';
        if(k == 2) return 'b';
        StringBuilder word = new StringBuilder("a");
        while(word.length() < 501 || word.length() < k) {
            int len = word.length();
            for(int i = 0; i < len; i++) {
                word.append((char)((int) word.charAt(i) + 1));
            }
        }

        return word.charAt(k - 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char kthCharacter(int k) {
        if(k == 1) return 'a';
        if(k == 2) return 'b';
        string word = "a";
        while(word.length() < 501 || word.length() < k) {
            int len = word.length();
            for(int i = 0; i < len; i++) {
                word += (char)(word[i] + 1);
            }
        }

        return word[k - 1];
    }
};
```

## Method - 2 (Optimised)

### Java

```java
class Solution {
    public char kthCharacter(int k) {
        if(k == 1) return 'a';
        if(k == 2) return 'b';
        int steps = 0;
        int pow = 0;
        double log2 = Math.log(2);

        while(k != 1) {
            pow = (int)(Math.log(k) / log2);
            if((1 << pow) == k) {
                pow--;
            }
            k = k - (1 << pow);
            steps++;
        }     

        return (char)('a' + steps); 
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char kthCharacter(int k) {
        if(k == 1) return 'a';
        if(k == 2) return 'b';
        int steps = 0;
        int pow = 0;
        double log2 = log(2);

        while(k != 1) {
            pow = (int)(log(k) / log2);
            if((1 << pow) == k) {
                pow--;
            }
            k = k - (1 << pow);
            steps++;
        }

        return 'a' + steps;
    }
};
```

### Explanation:

The optimized approach works by observing how characters are formed in each operation. If you travel **backward** from the `k`-th position, you can determine how many transformations (`+1`) have occurred to reach this position. Every time you subtract the largest power of 2 which is just less than `k`, you move to the position from which the character was derived, eventually reaching the original `'a'`. The number of steps taken to get there determines how many times the character has been incremented from `'a'`.
