Leetcode Question : [Minimum Domino Rotations For Equal Row](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/)

## Java

```java
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }
    
    private int check(int x, int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotTop = 0, rotBot = 0;
        
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            }
            if (tops[i] != x) {
                rotTop++;
            }
            if (bottoms[i] != x) {
                rotBot++;
            }
        }
        return rotTop < rotBot ? rotTop : rotBot;
    }
}

```

## C++

###

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }

private:
    int check(int x, vector<int>& tops, vector<int>& bottoms) {
        int n = tops.size();
        int rotTop = 0, rotBot = 0;

        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            }
            if (tops[i] != x) {
                rotTop++;
            }
            if (bottoms[i] != x) {
                rotBot++;
            }
        }
        return min(rotTop, rotBot);
    }
};
```
