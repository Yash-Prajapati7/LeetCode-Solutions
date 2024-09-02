Leetcode Question : [Find the Student That Will Replace the Chalk](https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/)

### Java
```java
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalSum = 0;
        for (int c : chalk) {
            totalSum += c;
        }
        
        k %= totalSum; // Efficiently reduce k to be within the bounds of totalSum
        
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i; // Find the student who can't complete their turn
            }
            k -= chalk[i];
        }
        return 0;
    }
}
```

### C++
```cpp
#include <vector>
using namespace std;

class Solution {
public:
    int chalkReplacer(vector<int>& chalk, int k) {
        long long totalSum = 0;
        for (int c : chalk) {
            totalSum += c;
        }
        
        k %= totalSum; // Efficiently reduce k to be within the bounds of totalSum
        
        for (int i = 0; i < chalk.size(); i++) {
            if (chalk[i] > k) {
                return i; // Find the student who can't complete their turn
            }
            k -= chalk[i];
        }
        return 0;
    }
};
```
