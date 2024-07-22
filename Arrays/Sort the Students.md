Leetcode Question : [Sort the Students](https://leetcode.com/problems/sort-the-students-by-their-kth-score/)
## Method - 1
### Java
```java
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
```
### C++
```cpp
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        sort(score.begin(), score.end(), k {
            return b[k] < a[k];
        });
        return score;
    }
};
```

## Method - 2
### Java
```java
class Pair {
    int value;
    int index;
    Pair(int val, int ind) {
        this.value = val;
        this.index = ind;
    }
}

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        int rows = score.length;
        int cols = score[0].length;
        int i = 0;
        for (int[] row : score) {
            pq.add(new Pair(row[k], i));
            i++;
        }

        int[][] result = new int[rows][cols];
        for (i = 0; i < rows; i++) {
            Pair p = pq.poll();
            result[i] = score[p.index];
        }
        return result;
    }
}
```
