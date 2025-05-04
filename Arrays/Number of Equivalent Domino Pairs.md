Leetcode Question : [Number of Equivalent Domino Pairs](https://leetcode.com/problems/number-of-equivalent-domino-pairs/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int a = 0, b = 0, c = 0, d = 0;
        int pairs = 0;
        for(int i = 0;  i < n; i++) {
            a = dominoes[i][0];
            b = dominoes[i][1];
            for(int j = i + 1; j < n; j++) {
                c = dominoes[j][0];
                d = dominoes[j][1];
                if((a == c && b == d) || (a == d && b == c)) pairs++;
            }
        }

        return pairs;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int n = dominoes.size();
        int a = 0, b = 0, c = 0, d = 0;
        int pairs = 0;
        for(int i = 0; i < n; i++) {
            a = dominoes[i][0];
            b = dominoes[i][1];
            for(int j = i + 1; j < n; j++) {
                c = dominoes[j][0];
                d = dominoes[j][1];
                if((a == c && b == d) || (a == d && b == c)) pairs++;
            }
        }
        return pairs;
    }
};
```

## Method - 2 (Using Hashing)

### Java

```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];   // At max the hash value can be 99
        int res = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                ? domino[0] * 10 + domino[1]
                : domino[1] * 10 + domino[0];
            res += num[val];
            num[val]++;
        }
        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int num[100] = {0};  // At max the hash value can be 99
        int res = 0;
        for (auto& domino : dominoes) {
            int val = domino[0] < domino[1]
                ? domino[0] * 10 + domino[1]
                : domino[1] * 10 + domino[0];
            res += num[val];
            num[val]++;
        }
        return res;
    }
};
```
