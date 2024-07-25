Leetcode Question : [Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/)

### Java
```java
class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = {-1, -1, -1};  // initialise the array with -1 for a, b & c
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            freq[val] = i;
            count += (1 + Math.min(freq[0], Math.min(freq[1], freq[2])));
        }

        return count;
    }
}
```
### C++
```cpp
class Solution {
public:
    int numberOfSubstrings(string s) {
        int freq[3] = {-1, -1, -1};  // initialise the array with -1 for a, b & c
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s[i] - 'a';
            freq[val] = i;
            count += (1 + min({freq[0], freq[1], freq[2]}));
        }

        return count;
    }
};
```
## Dry run for the input `s = "abcabc"`
### Initial State
- freq: [-1, -1, -1]
- count: 0

### Iteration 1 (i = 0, s[0] = 'a')
- val = 'a' - 'a' = 0
- Update freq[0] to 0: freq = [0, -1, -1]
- Calculate min(freq): min(0, -1, -1) = -1
- count += (1 + (-1)) = 0

### Iteration 2 (i = 1, s[1] = 'b')
- val = 'b' - 'a' = 1
- Update freq[1] to 1: freq = [0, 1, -1]
- Calculate min(freq): min(0, 1, -1) = -1
- count += (1 + (-1)) = 0

### Iteration 3 (i = 2, s[2] = 'c')
- val = 'c' - 'a' = 2
- Update freq[2] to 2: freq = [0, 1, 2]
- Calculate min(freq): min(0, 1, 2) = 0
- count += (1 + 0) = 1

### Iteration 4 (i = 3, s[3] = 'a')
- val = 'a' - 'a' = 0
- Update freq[0] to 3: freq = [3, 1, 2]
- Calculate min(freq): min(3, 1, 2) = 1
- count += (1 + 1) = 3

### Iteration 5 (i = 4, s[4] = 'b')
- val = 'b' - 'a' = 1
- Update freq[1] to 4: freq = [3, 4, 2]
- Calculate min(freq): min(3, 4, 2) = 2
- count += (1 + 2) = 6

### Iteration 6 (i = 5, s[5] = 'c')
- val = 'c' - 'a' = 2
- Update freq[2] to 5: freq = [3, 4, 5]
- Calculate min(freq): min(3, 4, 5) = 3
- count += (1 + 3) = 10

### Final State
- count: 10
